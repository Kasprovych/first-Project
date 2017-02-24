package ua.controller.adnim;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.editor.BrandEditor;
import ua.editor.KindEditor;
import ua.editor.PowerEditor;
import ua.editor.SizeEditor;
import ua.entity.Brand;
import ua.entity.Item;
import ua.entity.Kind;
import ua.entity.Power;
import ua.entity.Size;
import ua.service.BrandService;
import ua.service.ItemService;
import ua.service.KindService;
import ua.service.PowerService;
import ua.service.SizeService;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes(names = "item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private KindService kindService;

	@Autowired
	private PowerService powerService;

	@Autowired
	private SizeService sizeService;

	@InitBinder("item")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Kind.class, new KindEditor(kindService));
		binder.registerCustomEditor(Power.class, new PowerEditor(powerService));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeService));

	}

	@ModelAttribute("item")
	public Item getForm() {
		return new Item();
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("kinds", kindService.findAll());
		model.addAttribute("powers", powerService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		return "admin-item";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		itemService.delete(id);
		return "redirect:/admin/item";
	}
	
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("item") Item item, SessionStatus sessionStatus){
		itemService.save(item);
		sessionStatus.setComplete();
		return "redirect:/admin/item";
	}

}
