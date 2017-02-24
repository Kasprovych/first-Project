package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Kind;
import ua.service.KindService;

public class KindValidator implements Validator {
	
	KindService kindService;
	
	

	public KindValidator(KindService kindService) {
		this.kindService = kindService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Kind.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Kind kind = (Kind) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "", "can`t be empty");
		
		if(kindService.findOne(kind.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
			
	}

}
