package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository repository;

	@Transactional(readOnly = true)
	public Brand findOne(int id) {
		return repository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Brand> findAll() {
		return repository.findAll();
	}

	public void save(Brand brand) {
		repository.save(brand);

	}

	public void delete(int id) {
		repository.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Brand findOne(String name) {
		return repository.findByName(name);
	
	}

}
