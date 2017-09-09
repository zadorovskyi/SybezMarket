package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.CategoryFirstLevel;
import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.repository.CategoryFirstLevelRepository;
import org.sybez.validators.admin.forms.Validators;

@Service
public class CategoryFirstLevelService {

	@Autowired
	private CategoryFirstLevelRepository categoryFirstLevelRepository;
	@Autowired
	private Validators validator;

	public List<CategoryFirstLevel> getAll() {
		return categoryFirstLevelRepository.findAll();
	}
	
	public CategoryFirstLevel getByName(String name){
		return categoryFirstLevelRepository.findCatByName(name);
	}
	
	public void saveCategoryFirstLevel(String categoryName){
		CategoryFirstLevel newCategory = validator.firstCategoryNameValidation(categoryName);
		categoryFirstLevelRepository.save(newCategory);
	}
	public CategoryFirstLevel getdById(int id){
		return categoryFirstLevelRepository.findOne(id);
	}

}
