package org.sybez.service.editor;

import java.beans.PropertyEditorSupport;

import org.sybez.dao.entity.CategorySecondLevel;
import org.sybez.dao.service.CategorySecondLevelService;

public class CategorySecondLevelEditor extends PropertyEditorSupport{
	
	private final CategorySecondLevelService categorySecondLevelService;
	
	public CategorySecondLevelEditor(CategorySecondLevelService categorySecondLevelService){
		this.categorySecondLevelService = categorySecondLevelService;
	}

public void setAsText(String text) throws IllegalArgumentException{
	System.out.println("setAsTextCategory");
	CategorySecondLevel category = categorySecondLevelService.getById(Integer.parseInt(text));
	setValue(category);
	
}
	
}
