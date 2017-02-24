package ua.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.entity.Country;
import filter.BasicFilter;

public class CountySpecification implements Specification<Country> {
	
	private final BasicFilter filter;

	public CountySpecification(BasicFilter filter) {
		
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query,
			CriteriaBuilder builder) {
		
		if(filter.getSearch().isEmpty())
			return null;
		
		Expression<String> exp = root.get("name");
		return builder.like(exp, filter.getSearch()+"%");
	}
	
	
	
}
