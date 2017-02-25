package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.SizeForm;

public class SizeValidator implements Validator {
	
	private final static Pattern PATTERN = Pattern.compile("^[0-9]{1,5}$");

	@Override
	public boolean supports(Class<?> clazz) {
		return SizeForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SizeForm sizeForm = (SizeForm) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "length", "", "Please enter");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "", "Please enter");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "", "Please enter");
		
		if(!PATTERN.matcher(sizeForm.getLength()).matches()){
			errors.rejectValue("length", "", "digits only");
			
		}
		if(!PATTERN.matcher(sizeForm.getWidth()).matches()){
			errors.rejectValue("width", "", "digits only");
			
		}
		if(!PATTERN.matcher(sizeForm.getHeight()).matches()){
			errors.rejectValue("height", "", "digits only");
			
		}
	}

}
