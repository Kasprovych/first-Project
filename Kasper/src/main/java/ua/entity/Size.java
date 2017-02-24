package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "size")
public class Size extends AbstractEntity {
	
		
	@Column(name = "length")
	private Integer length;
	
	@Column(name = "width")
	private Integer width;
	
	@Column(name = "height")
	private Integer height;
	
	@OneToMany(mappedBy="size")
	List<Item> items = new ArrayList<>();

	public Size() {
	}
	
	public String getPresentation(){
		String a = String.valueOf(getLength());
		String b = String.valueOf(getWidth());
		String c = String.valueOf(getHeight());
		return "Length:" + a + ", " + "Width:" + b + ", " + "Height:" + c;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
	
	
	

}
