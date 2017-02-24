package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Kind;
import ua.repository.KindRepository;
import ua.service.KindService;
@Service
public class KindServiceImpl implements KindService {
	
	@Autowired
	KindRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Kind findOne(int id) {
		return repository.findOne(id);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Kind findOne(String name) {
		return repository.findByName(name);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Kind> findAll() {
		return repository.findAll();
	}
	


	@Override
	public void save(Kind kind) {
		repository.save(kind);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	

	

}
