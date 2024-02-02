package br.com.erudio.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {
	
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return modelMapper.map(origin, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		
		return origin.stream().map(orig ->{
			return modelMapper.map(orig, destination);
		}).collect(Collectors.toList());
		
	}
	

}
