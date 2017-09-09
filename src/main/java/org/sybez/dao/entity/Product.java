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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Product {

	@Id 
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="generator")
	private int id;
	private String productName;
	private long productPrice;
	private IsAvaliable isAvaliable;
	private String discription;
	private String imageUrl;
	@ManyToOne
	private CategorySecondLevel categorySecondLevel;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH}, fetch = FetchType.LAZY)
	@JoinTable(name = "makers_products", joinColumns = @JoinColumn(name = "fk_products") , inverseJoinColumns = @JoinColumn(name = "fk_makers") )
	private List<Maker> makers = new ArrayList<Maker>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "fk_product") , inverseJoinColumns = @JoinColumn(name = "fk_order") )
	private List<Order_> orders = new ArrayList<Order_>();

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public IsAvaliable getIsAvaliable() {
		return isAvaliable;
	}

	public void setAvaliable(IsAvaliable isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	public CategorySecondLevel getCategorySecondLevel() {
		return categorySecondLevel;
	}

	public void setCategorySecondLevel(CategorySecondLevel categorySecondLevel) {
		this.categorySecondLevel = categorySecondLevel;
	}
	

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<Maker> getMakers() {
		return makers;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setMakers(Maker maker) {
		this.makers.add(maker);
	}

	public List<Order_> getOrder() {
		return orders;
	}

	public void setOrder(Order_ order) {
		this.orders.add(order);
	}
	
}
