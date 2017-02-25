package ua.service;

import java.util.List;

import ua.dto.form.SizeForm;
import ua.entity.Size;

public interface SizeService {
	
	Size findOne(int id);
	
	SizeForm findForm(int id);
	
	List<Size>  findAll();
	
	void save(SizeForm sizeForm);
	
	void delete(int id);


}
