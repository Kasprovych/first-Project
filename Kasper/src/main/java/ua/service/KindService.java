package ua.service;

import java.util.List;

import ua.entity.Kind;

public interface KindService {
	

	Kind findOne(int id);
	
	Kind findOne(String name);
	
	List<Kind> findAll();
	
	void save(Kind kind);
	
	void delete(int id);


}
