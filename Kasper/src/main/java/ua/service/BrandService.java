package ua.service;

import java.util.List;

import ua.entity.Brand;

public interface BrandService {
	
	Brand findOne(int id);
	
	Brand findOne(String name);
	
	List<Brand> findAll();
	
	void save(Brand brand);
	
	void delete(int id);
	
	

}
