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

import ua.dto.form.PowerForm;
import ua.entity.Power;
import ua.service.PowerService;
import ua.validator.KindValidator;
import ua.validator.PowerValidator;

@Controller
@RequestMapping("/admin/power")
@SessionAttributes(names = "power")
public class PowerController {

	@Autowired
	public PowerService powerService;

	@ModelAttribute("power")
	public PowerForm getForm() {
		return new PowerForm();
	}

	@InitBinder("power")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new PowerValidator());
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("powers", powerService.findAll());
		return "admin-power";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		powerService.delete(id);
		return "redirect:/admin/power";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("power", powerService.findForm(id));
		model.addAttribute("powers", powerService.findAll());
		return "admin-power";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("power") @Valid PowerForm powerForm, BindingResult br, Model model,
			SessionStatus status) {

		if (br.hasErrors()) {
			show(model);
			return "admin-power";
		}

		powerService.save(powerForm);
		status.setComplete();
		return "redirect:/admin/power";
	}

}
