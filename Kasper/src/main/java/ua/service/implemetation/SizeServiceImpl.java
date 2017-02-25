package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.SizeForm;
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
	public void save(SizeForm sizeForm) {
		Size size = new Size();
		size.setId(sizeForm.getId());
		size.setHeight(Integer.valueOf(sizeForm.getHeight()));
		size.setLength(Integer.valueOf(sizeForm.getLength()));
		size.setWidth(Integer.valueOf(sizeForm.getWidth()));
		repository.save(size);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public SizeForm findForm(int id) {
		Size entitySize = repository.findOne(id);
		SizeForm sizeForm = new SizeForm();
		sizeForm.setId(entitySize.getId());
		sizeForm.setHeight(String.valueOf(entitySize.getHeight()));
		sizeForm.setLength(String.valueOf(entitySize.getLength()));
		sizeForm.setWidth(String.valueOf(entitySize.getWidth()));
		return sizeForm;
	}

		
	}


