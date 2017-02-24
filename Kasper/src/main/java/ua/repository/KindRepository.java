package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Kind;

public interface KindRepository extends JpaRepository<Kind, Integer> {
	
	Kind findByName(String name);
	

}
