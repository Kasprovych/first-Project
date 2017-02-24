package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Size;
import ua.service.SizeService;

public class SizeEditor  extends PropertyEditorSupport {
	
	private final SizeService sizeService;

	public SizeEditor(SizeService sizeService) {
		this.sizeService = sizeService;
		
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Size size = sizeService.findOne(Integer.valueOf(text));
		setValue(size);
	}
	
	
	

}
