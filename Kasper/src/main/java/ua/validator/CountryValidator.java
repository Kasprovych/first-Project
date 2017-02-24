package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Country;
import ua.service.CountryService;

public class CountryValidator implements Validator {
	
	CountryService countryService;
	
	

	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Country country = (Country) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "", "can`t be empty");
		
		if(countryService.findOne(country.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		
	}

}
