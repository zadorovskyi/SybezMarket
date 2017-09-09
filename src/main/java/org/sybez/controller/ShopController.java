package org.sybez.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sybez.config.Config;
import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.entity.Client;
import org.sybez.dao.service.CategoryFirstLevelService;
import org.sybez.dao.service.CategorySecondLevelService;
import org.sybez.dao.service.ClientService;
import org.sybez.dao.service.ProductService;

@Controller
public class ShopController{

	@Autowired
	CategoryFirstLevelService categoryFirstLevelService;
	@Autowired
	CategorySecondLevelService categorySecondLevelService;
	@Autowired
	ProductService productService;
	@Autowired
	ClientService CclientService;
	

	@RequestMapping(value="/index")
	public String getMainPage(HttpServletRequest request,HttpServletRequest response){
		return "index";
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public String getMainAdmin(@RequestParam(value = "id", defaultValue = "1")int id,Model model) {
		model.addAttribute("products", productService.getProductByIdOfSecondCat(id));
		model.addAttribute("currency", Config.getInstance());
		return "shop/page";
	}


}
