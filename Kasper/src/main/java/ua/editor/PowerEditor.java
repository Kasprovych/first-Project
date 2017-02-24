package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Power;
import ua.service.PowerService;

public class PowerEditor extends PropertyEditorSupport {
	
	private final PowerService powerService;
	
	public PowerEditor (PowerService powerService) {
		this.powerService = powerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Power power = powerService.findOne(Integer.valueOf(text));
		setValue(power);
	}
	
	

}
