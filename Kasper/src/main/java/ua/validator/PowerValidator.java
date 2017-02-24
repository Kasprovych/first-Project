package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.PowerForm;

public class PowerValidator implements Validator {

	private final static Pattern PATTERN = Pattern.compile("^[0-9]{1,2}$");


	@Override
	public boolean supports(Class<?> clazz) {
		return PowerForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PowerForm powerForm = (PowerForm) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxPower", "", "Please enter");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "voltageAtMaxPover", "", "Please enter");

		if (!PATTERN.matcher(powerForm.getMaxPower()).matches()) {
			errors.rejectValue("maxPower", "", "digits only and just 1 to 99");

		}
		if (!PATTERN.matcher(powerForm.getVoltageAtMaxPover()).matches()) {
			errors.rejectValue("voltageAtMaxPover", "", "digits only and just 1 to 99");

		}

	}

}
