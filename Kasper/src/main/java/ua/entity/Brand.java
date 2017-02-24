package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "brand")
public class Brand extends AbstractEntity {
	
	@Column(name = "_name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	@OneToMany(mappedBy="brand")
	private List <Item> items = new ArrayList<>();

	public Brand() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
