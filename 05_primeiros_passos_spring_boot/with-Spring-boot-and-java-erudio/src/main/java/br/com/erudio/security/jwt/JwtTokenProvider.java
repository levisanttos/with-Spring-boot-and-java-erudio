package br.com.erudio.security.jwt;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import br.com.erudio.data.vo.v1.secutiry.TokenVO;
import br.com.erudio.exceptions.InvalidJwtAuthenticationException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class JwtTokenProvider {

	@Value("${security.jwt.secret-key:secret}")
	private String secretKey;
	
	@Value("${security.jwt.expire-length:3600000}")
	private Long validInMilliseconds;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	Algorithm algorithm;
	
	@PostConstruct
	public void initi() {
		// faz a criptografia da secretkey
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}
	
	public TokenVO createAccessToken(String username, List<String> roles) {
		Date dateNow = new Date();
		Date validity = new Date(dateNow.getTime() + validInMilliseconds);
		var accessToken = getAccessToken(username, roles, dateNow, validity);
		var refreshToken = getRefreshToken(username, roles, dateNow);
		return new TokenVO(username, true, dateNow, validity, accessToken, refreshToken);
	}

	private String getRefreshToken(String username, List<String> roles, Date dateNow) {
		Date validityRefreshToken = new Date(dateNow.getTime() + (validInMilliseconds * 3));
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(dateNow)
				.withExpiresAt(validityRefreshToken)
				.withSubject(username)
				.sign(algorithm)
				.strip();
	}

	private String getAccessToken(String username, List<String> roles, Date dateNow, Date validity) {
		String issueUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(dateNow)
				.withExpiresAt(validity)
				.withSubject(username)
				.withIssuer(issueUrl)
				.sign(algorithm)
				.strip();
	}
	
	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());
		return new UsernamePasswordAuthenticationToken(decodedJWT,"" ,userDetails.getAuthorities());
	}

	private DecodedJWT decodedToken(String token) {
		Algorithm algo = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(algo).build();
		DecodedJWT decodedJWT = verifier.verify(token);
		
		return decodedJWT;
	}
	
	public String resolveToken(HttpServletRequest httpServletRequest) {
		
		String bearerToken = httpServletRequest.getHeader("Authorization");
		
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		
		return null;
	}
	
	public boolean validateToken(String token) {
		
		DecodedJWT decodedJWT = this.decodedToken(token);
		
		try {
			if (decodedJWT.getExpiresAt().before(new Date())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new InvalidJwtAuthenticationException("Expired or invalid JWT token!");
		}
	}
}
