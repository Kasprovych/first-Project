package ua.service;

import java.util.List;

import ua.dto.form.PowerForm;
import ua.entity.Power;

public interface PowerService {
	
	Power findOne(int id);
	
	PowerForm findForm(int id);
	
	List<Power> findAll();
	
	void save(PowerForm powerForm);
	
	void delete(int id);


}
