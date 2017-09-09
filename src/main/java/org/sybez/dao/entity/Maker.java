package org.sybez.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Maker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String makerName;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinTable(name = "makers_products", joinColumns = @JoinColumn(name = "fk_makers") , inverseJoinColumns = @JoinColumn(name = "fk_products"))
	private List<Product> products = new ArrayList<Product>();

	public Maker() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(Product product) {
		this.products.add(product);
	}

}
