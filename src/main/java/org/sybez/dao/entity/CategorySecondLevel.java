package org.sybez.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CategorySecondLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String categorySecondLevelName;

	@ManyToOne
	private CategoryFirstLevel categoryFirstLevel;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorySecondLevel")
	private List<Product> products;

	public CategorySecondLevel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorySecondLevelName() {
		return categorySecondLevelName;
	}

	public void setCategorySecondLevelName(String categorySecondLevelName) {
		this.categorySecondLevelName = categorySecondLevelName;
	}

	public CategoryFirstLevel getCategoryFirstLevel() {
		return categoryFirstLevel;
	}

	public void setCategoryFirstLevel(CategoryFirstLevel categoryFirstLevel) {
		this.categoryFirstLevel = categoryFirstLevel;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
