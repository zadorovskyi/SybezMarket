package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.CategoryFirstLevel;
import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.repository.CategorySecondLevelRepository;
import org.sybez.validators.admin.forms.Validators;

@Service
public class CategorySecondLevelService{

	@Autowired
	private CategorySecondLevelRepository categorySecondLevelRepository;
	@Autowired
	Validators validator;

	public List<CategorySecondLevel> getAllSecondCatByIdOfTheFirstCat(int  id) {
		return categorySecondLevelRepository.findAllCategoriesSecondLevelInCategoryFirstLevelByIdFirstLev(id);
	}
	
	public List<CategorySecondLevel> getAll() {
		return categorySecondLevelRepository.findAll();
	}

	public CategorySecondLevel getById(int id) {
		return categorySecondLevelRepository.getOne(id);
	}
	
	public CategorySecondLevel getByName(String name){
		return categorySecondLevelRepository.findCatByName(name);
	}
	
	public void saveCategorySecondLevel(String categoryName, CategoryFirstLevel categoryFirstLev){
		CategorySecondLevel newCategory = validator.secondCategoryNameValidation(categoryName,categoryFirstLev);
		categorySecondLevelRepository.save(newCategory);
	}
}
