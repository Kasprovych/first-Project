package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "power")
public class Power extends AbstractEntity {

	
	@Column(name = "max_power")
	private Integer maxPower;
	
	@Column(name = "voltage_at_max_pover")
	private Integer voltageAtMaxPover;
	
	@OneToMany(mappedBy="power")
	List<Item> items = new ArrayList<>();

	public Power() {
		
	}


	public String getPresentation(){
		String a = String.valueOf(getMaxPower());
		String b = String.valueOf(getVoltageAtMaxPover());
		
		return "maxPower: " + a + "mV" + ", voltageAtMaxPover: " + b + "mVp";
	}

	public Integer getVoltageAtMaxPover() {
		return voltageAtMaxPover;
	}

	public void setVoltageAtMaxPover(Integer voltageAtMaxPover) {
		this.voltageAtMaxPover = voltageAtMaxPover;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getMaxPower() {
		return maxPower;
	}


	public void setMaxPower(Integer maxPower) {
		this.maxPower = maxPower;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxPower == null) ? 0 : maxPower.hashCode());
		result = prime * result + ((voltageAtMaxPover == null) ? 0 : voltageAtMaxPover.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Power other = (Power) obj;
		if (maxPower == null) {
			if (other.maxPower != null)
				return false;
		} else if (!maxPower.equals(other.maxPower))
			return false;
		if (voltageAtMaxPover == null) {
			if (other.voltageAtMaxPover != null)
				return false;
		} else if (!voltageAtMaxPover.equals(other.voltageAtMaxPover))
			return false;
		return true;
	}
	


	
	

}
