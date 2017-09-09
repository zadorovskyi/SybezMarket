package org.sybez.validators.admin.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.CategoryFirstLevel;
import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.entity.Product;
import org.sybez.dao.repository.CategoryFirstLevelRepository;
import org.sybez.dao.repository.CategorySecondLevelRepository;

@Service
public class Validators {
	
	@Autowired
	CategoryFirstLevelRepository categoryFirstLevelRepository;
	@Autowired
	CategorySecondLevelRepository categorySecondLevelRepository;
	

	public CategoryFirstLevel firstCategoryNameValidation(String name){
		if(categoryFirstLevelRepository.findCatByName(name)==null){
			CategoryFirstLevel categoryFirstLevel = new CategoryFirstLevel();
			categoryFirstLevel.setCategoryFirstLevelName(name.toUpperCase());
			return categoryFirstLevel;
		}
		return categoryFirstLevelRepository.findCatByName(name);
	}
	
	public CategorySecondLevel secondCategoryNameValidation(String name,CategoryFirstLevel catFirstLevel){
		if(categorySecondLevelRepository.findCatByName(name)==null){
			CategorySecondLevel categorySecondLevel = new CategorySecondLevel();
			categorySecondLevel.setCategorySecondLevelName(name.toUpperCase());
			categorySecondLevel.setCategoryFirstLevel(catFirstLevel);
			return categorySecondLevel;
		}
		return categorySecondLevelRepository.findCatByName(name);
	}
}

