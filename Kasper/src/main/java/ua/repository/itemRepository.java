package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Brand;
import ua.entity.Item;

public interface itemRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT b FROM Item b LEFT JOIN FETCH b.brand LEFT JOIN FETCH b.kind LEFT JOIN FETCH b.power LEFT JOIN FETCH b.size")
	List<Item> findAll();
	
	


}
