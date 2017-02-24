package ua.service.implemetation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.repository.itemRepository;
import ua.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired 
	itemRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Item findOne(int id) {
		return repository.findOne(id);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Item> findAll() {
		return repository.findAll();
	}
	@Override
	public void save(Item item) {
		repository.save(item);
	}
	@Override
	public void delete(int id) {
		repository.delete(id);
	}


	
	

}
