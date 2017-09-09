package org.sybez.controller;

import javax.mail.Session;
import javax.persistence.Transient;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sybez.config.Config;
import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.entity.Maker;
import org.sybez.dao.entity.Product;
import org.sybez.dao.service.CategoryFirstLevelService;
import org.sybez.dao.service.CategorySecondLevelService;
import org.sybez.dao.service.MakerService;
import org.sybez.dao.service.ProductService;
import org.sybez.service.editor.CategorySecondLevelEditor;
import org.sybez.service.editor.MakerEditor;
import org.sybez.service.validator.ProductAddingFormValidator;

@Controller
public class AdminController {

	@Autowired
	private CategoryFirstLevelService categoryFirstLevelService;
	@Autowired
	private CategorySecondLevelService categorySecondLevelService;
	@Autowired
	private ProductService productService;
	@Autowired
	MakerService makerService;
	@Autowired
	@Qualifier("productAddingFormValidator")
	ProductAddingFormValidator productAddingFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(CategorySecondLevel.class, new CategorySecondLevelEditor(categorySecondLevelService));
		binder.registerCustomEditor(Maker.class, new MakerEditor(makerService));
		binder.setValidator(productAddingFormValidator);
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getMainAdmin(Model model) {
		model.addAttribute("categoryFirstLevel", categoryFirstLevelService.getAll());
		System.out.println("ADMIN");
		return "adminFirstLevelCat";
	}// GOOD

	@RequestMapping(value = "/admin/categorySecondLevel", method = RequestMethod.POST)
	public String getMainAdminFormCategoryFirst(Model model, @RequestParam("categoryFirstLevel") int id) {
		model.addAttribute("categorySecondLevel", categorySecondLevelService.getAllSecondCatByIdOfTheFirstCat(id));
		System.out.println(categoryFirstLevelService.getdById(id).getCategoryFirstLevelName());
		return "redirect:/admin/categorySecondLevel/" + id + "/";
	}// GOOD
	

	@RequestMapping(value = "/admin/createCategoryFirstLevel", method = RequestMethod.POST)
	public String сreateCategoryFirstLevel(@RequestParam("categoryFirstLevelName") String categoryName) {
		categoryFirstLevelService.saveCategoryFirstLevel(categoryName);
		return "redirect:/admin";
	}// GOOD
	
	@RequestMapping(value = "/admin/createMaker", method = RequestMethod.POST)
	public String сreateMaker(@RequestParam("newMaker") String newMaker) {
		makerService.saveMaker(newMaker);
		return "redirect:/admin";
	}// GOOD

	@RequestMapping(value = "/admin/categorySecondLevel/{id}/createCategorySecondLevel", method = RequestMethod.POST)
	public String reateCategorySecondLevel(@RequestParam("categorySecondLevelName") String categorySecondLevelName,
			@PathVariable("id") int id) {
		categorySecondLevelService.saveCategorySecondLevel(categorySecondLevelName,
				categoryFirstLevelService.getdById(id));
		return "redirect:/admin/categorySecondLevel/{id}/";
	}
	@RequestMapping(value = "/admin/categorySecondLevel/{id}", method = RequestMethod.GET)
	public String getMainAdminFormCategorySecondLevel(@PathVariable("id") int id, Model model) {
		model.addAttribute("categorySecondLevel", categorySecondLevelService.getAllSecondCatByIdOfTheFirstCat(id));
		model.addAttribute("makers", makerService.getAll());
		model.addAttribute("newProduct",new Product());
		return "adminSecondLevelCat";
	}
	@Transactional
	@RequestMapping(value = "/admin/categorySecondLevel/{id}/addNewProduct", method = RequestMethod.POST)
	public String addNewProduct(@Valid@ModelAttribute("newProduct") Product newProduct, BindingResult result,Model model,@PathVariable("id")int id) {
		if(result.hasErrors()){
			System.out.println(result.getFieldErrors());
			model.addAttribute("categorySecondLevel", categorySecondLevelService.getAllSecondCatByIdOfTheFirstCat(id));
			model.addAttribute("makers", makerService.getAll());
			return "adminSecondLevelCat";
		}
		productService.saveProduct(productService.creatingNewProductEntityWithUniqueId(newProduct));
		return "redirect:/admin/categorySecondLevel/{id}/";
	}

	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String getAllExistingProducts(Model model) {
		model.addAttribute("productList", productService.getAllProducts());
		return "adminAllProductsList";
	}

	@Transactional
	@RequestMapping(value = "/admin/product/{id}/edit", method = RequestMethod.GET)
	public String getProductEditMenuWithoutSecondCat(Model model, @PathVariable("id") int id) {
		Hibernate.initialize(productService.getById(id));
		Hibernate.initialize(categorySecondLevelService.getAll());
		Hibernate.initialize(productService.getById(id).getMakers());
		model.addAttribute("categorySecondLevel", categorySecondLevelService.getAll());
		model.addAttribute("productForEdit", productService.getById(id));
		model.addAttribute("config", Config.getInstance());
		model.addAttribute("makers", makerService.getAll());
		return "adminProductEdit";
	}

	@RequestMapping(params = "/admin/product/{id}/edit", method = RequestMethod.POST)
	public String productEditing(@ModelAttribute("productForEdit") Product productForEdit,BindingResult result,Model model,@PathVariable("id") int id) {
		productAddingFormValidator.validate(productForEdit, result);
		if(result.hasErrors()){
			model.addAttribute("categorySecondLevel", categorySecondLevelService.getAll());
			model.addAttribute("config", Config.getInstance());
			model.addAttribute("makers", makerService.getAll());
			return "adminProductEdit";
		}
		productService.saveProduct(productForEdit);
		return "redirect:/admin/product/{id}/edit";
	}

	@RequestMapping(value = "/admin/product/{id}/delete", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id) {
		System.out.println("delete");
		productService.deleteProduct(id);
		return "redirect:/admin/product";
	}

}
