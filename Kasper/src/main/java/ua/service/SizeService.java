package ua.service;

import java.util.List;

import ua.entity.Size;

public interface SizeService {
	
	Size findOne(int id);
	
	List<Size>  findAll();
	
	void save(Size size);
	
	void delete(int id);


}
