package org.sybez.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sybez.dao.entity.Client;
import org.sybez.dao.service.CategoryFirstLevelService;
import org.sybez.dao.service.CategorySecondLevelService;
import org.sybez.dao.service.ClientNameService;
import org.sybez.dao.service.ClientService;
import org.sybez.dao.service.ProductService;
import org.sybez.service.editor.ClientNameEditor;

@Controller
public class Registration {

	@Autowired
	CategoryFirstLevelService categoryFirstLevelService;
	@Autowired
	CategorySecondLevelService categorySecondLevelService;
	@Autowired
	ProductService productService;
	@Autowired
	ClientService clientService;
	private int id;
	@Autowired
	ClientNameService clientNameService;
	@Autowired
	@Qualifier("registrationValidator")
	Validator validator;
	@Autowired
	@Qualifier("clientNameValidator")
	Validator validatorClientName;

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(org.sybez.dao.entity.ClientName.class, new ClientNameEditor(clientNameService));
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registraion(Model model) {
		model.addAttribute("client", new Client());
		return "registration/registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registraionOfTheClient(@Valid @ModelAttribute("client") Client client, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registration/registration";
		}
		clientService.saveNewClient(client);
		System.out.println(client);
		System.out.println(client.getClientName().getClientName());

		// model.addAttribute("client", clientService.getById(id));
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "registration/login";
	}



}
