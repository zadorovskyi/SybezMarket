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
public class PostDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String postDepartmentAdress;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "postDepartment")
	private List<Order_> orders;

	public PostDepartment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostDepartmentAdress() {
		return postDepartmentAdress;
	}

	public void setPostDepartmentAdress(String postDepartmentAdress) {
		this.postDepartmentAdress = postDepartmentAdress;
	}

	public List<Order_> getOrders() {
		return orders;
	}

	public void setOrders(List<Order_> orders) {
		this.orders = orders;
	}

}
