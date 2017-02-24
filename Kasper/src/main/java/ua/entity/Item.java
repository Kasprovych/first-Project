package ua.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "item")
public class Item  extends AbstractEntity{
	
	@Column(name="_name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Kind kind;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Power power;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Size size;
	
	@Column(name = "price")
	private BigDecimal price;

	public Item() {
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	

}
