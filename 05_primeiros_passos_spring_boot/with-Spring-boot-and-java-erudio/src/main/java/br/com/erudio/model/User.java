package br.com.erudio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8763121949284892001L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_person" )
	private Long id;

	@Column(name = "user_name", unique = true)
	private String username;
	
	@Column(name = "full_name")
	private String fullname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "account_non_expired")
	private boolean accountNonExpired;
	
	@Column(name = "account_non_locked")
	private boolean accountNonlocked;
	
	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;
	
	@Column(name = "enable")
	private boolean enable;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission", joinColumns = {@JoinColumn(name="id_user")}, 
		inverseJoinColumns = {@JoinColumn(name="id_permission")})
	private List<Permission> permissions;
	
	public User() {
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public void setAccountNonlocked(boolean accountNonlocked) {
		this.accountNonlocked = accountNonlocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for(Permission permission : this.permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonlocked;
	}
	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}
	

	@Override
	public boolean isEnabled() {
		return this.enable;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	
}
