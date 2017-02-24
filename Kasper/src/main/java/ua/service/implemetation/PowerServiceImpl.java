package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.PowerForm;
import ua.entity.Power;
import ua.repository.PowerRepository;
import ua.service.PowerService;
@Service
public class PowerServiceImpl implements PowerService{
	@Autowired
	PowerRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Power findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Power> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(PowerForm powerForm) {
		Power power = new Power();
		power.setId(powerForm.getId());
		power.setMaxPower(Integer.valueOf(powerForm.getMaxPower()));
		power.setVoltageAtMaxPover(Integer.valueOf(powerForm.getVoltageAtMaxPover()));
		repository.save(power);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public PowerForm findForm(int id) {
		Power entityPower = repository.findOne(id);
		PowerForm powerForm = new PowerForm();
		powerForm.setId(entityPower.getId());
		powerForm.setMaxPower(String.valueOf(entityPower.getMaxPower()));
		powerForm.setVoltageAtMaxPover(String.valueOf(entityPower.getVoltageAtMaxPover()));
		return powerForm;
	}

	
	

}
