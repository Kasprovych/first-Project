package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	@Query("SELECT b FROM Brand b LEFT JOIN FETCH b.country")
	List<Brand> findAll();
	
	@Query("SELECT b FROM Brand b LEFT JOIN FETCH b.country WHERE b.id = ?1")
	Brand findOne(Integer id);
	
	Brand findByName(String name);

}
