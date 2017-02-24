package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Size;
import ua.repository.SizeRepository;
import ua.service.SizeService;
@Service
public class SizeServiceImpl implements SizeService {
	@Autowired
	private SizeRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Size findOne(int id) {
		
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Size> findAll() {
		
		return repository.findAll();
	}

	@Override
	public void save(Size size) {

		repository.save(size);
	}

	@Override
	public void delete(int id) {
		
		repository.delete(id);
		
	}

		
	}


