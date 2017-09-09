package org.sybez.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoryFirstLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String categoryFirstLevelName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoryFirstLevel")
	private List<CategorySecondLevel> categorySecondLevel;

	public CategoryFirstLevel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryFirstLevelName() {
		return categoryFirstLevelName;
	}

	public void setCategoryFirstLevelName(String categoryFirstLevelName) {
		this.categoryFirstLevelName = categoryFirstLevelName;
	}

	public List<CategorySecondLevel> getCategorySecondLevel() {
		return categorySecondLevel;
	}

	public void setCategorySecondLevel(List<CategorySecondLevel> categorySecondLevel) {
		this.categorySecondLevel = categorySecondLevel;
	}
	

}
