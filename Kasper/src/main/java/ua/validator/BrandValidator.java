package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Brand;
import ua.service.BrandService;

public class BrandValidator implements Validator {
	
	private final BrandService brandService;

	public BrandValidator(BrandService brandService) {
		this.brandService = brandService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Brand.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Brand brand = (Brand) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "", "can`t be empty");
		
		if(brandService.findOne(brand.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
		
	}
	
	
	

}
