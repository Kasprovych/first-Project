package ua.controller.adnim;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.editor.CountryEditor;
import ua.entity.Brand;
import ua.entity.Country;
import ua.service.BrandService;
import ua.service.CountryService;
import ua.validator.BrandValidator;

@Controller
@RequestMapping("/admin/brand")
@SessionAttributes(names="brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CountryService countryService;
	
	@InitBinder("brand")
	protected void initBinder(WebDataBinder binder){
	   binder.setValidator(new BrandValidator(brandService));
	   binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
	}
	

	@ModelAttribute("brand")
	public Brand getForn() {
		return new Brand();
	}
	
	@RequestMapping
	public String show(Model model) {
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-brand";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		brandService.delete(id);
		return "redirect:/admin/brand";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		show(model);
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("brand", brandService.findOne(id));
		return "admin-brand";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("brand")@Valid Brand brand,BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "admin-brand";
			
		}
		brandService.save(brand);
		status.setComplete();
		return "redirect:/admin/brand";
	}

}
