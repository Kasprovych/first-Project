package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filter.BasicFilter;
import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;
import ua.service.specification.CountySpecification;
@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Country findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Country> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Country country) {
		repository.save(country);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public Page<Country> findAll(BasicFilter filter, Pageable pageable) {
		
		return repository.findAll(new CountySpecification(filter), pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Country findOne(String name) {
		return repository.findByName(name);
	}




}
