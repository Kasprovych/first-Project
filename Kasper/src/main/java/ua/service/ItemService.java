package ua.service;

import java.util.List;

import ua.entity.Item;

public interface ItemService {
	
	Item findOne(int id);
	
	List<Item> findAll();
	
	void save(Item item);
	
	void delete(int id);

}
