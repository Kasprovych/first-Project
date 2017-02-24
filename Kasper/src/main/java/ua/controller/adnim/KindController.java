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

import ua.entity.Kind;
import ua.service.KindService;
import ua.validator.KindValidator;
@Controller
@RequestMapping("/admin/kind")
@SessionAttributes(names="kind")
public class KindController {
	@Autowired
	public KindService kindService;

	@ModelAttribute("kind")
	public Kind getForn() {
		return new Kind();
	}
	
	@InitBinder("kind")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new KindValidator(kindService));
	}
	
	
	@RequestMapping
	public String show(Model model) {
		model.addAttribute("kinds", kindService.findAll());
		return "admin-kind";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		kindService.delete(id);
		return "redirect:/admin/kind";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("kind", kindService.findOne(id));
		model.addAttribute("kinds", kindService.findAll());
		return "admin-kind";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("kind") @Valid Kind kind, BindingResult br, Model model, 
			SessionStatus status){
		
		if(br.hasErrors()){
			show(model);
			return "admin-kind";
		}
	
		kindService.save(kind);
		status.setComplete();
		return "redirect:/admin/kind";
	}
	

}
