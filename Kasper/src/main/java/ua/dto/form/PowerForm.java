package ua.dto.form;

public class PowerForm {
	
	private Integer id;
	
	private String maxPower;
	
	private String voltageAtMaxPover;

	public PowerForm() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(String maxPower) {
		this.maxPower = maxPower;
	}

	public String getVoltageAtMaxPover() {
		return voltageAtMaxPover;
	}

	public void setVoltageAtMaxPover(String voltageAtMaxPover) {
		this.voltageAtMaxPover = voltageAtMaxPover;
	}
	
	
	

}
