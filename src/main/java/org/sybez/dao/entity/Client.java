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
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private USER_ROLE userRole;
	@ManyToOne(cascade=CascadeType.ALL)
	private ClientName clientName;
	private String password;
	private String surname;
	private String phoneNumber;
	private String eMail;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	private List<Order_> orders;

	public Client() {
		//userRole = USER_ROLE.ROLE_ADMIN;
		userRole = USER_ROLE.ROLE_USER;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClientName getClientName() {
		return clientName;
	}

	public void setClientName(ClientName clientName) {
		this.clientName = clientName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<Order_> getOrders() {
		return orders;
	}

	public void setOrders(List<Order_> orders) {
		this.orders = orders;
	}
	public USER_ROLE getUserRole() {
		return userRole;
	}

	public void setUserRole(USER_ROLE userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return clientName.getClientName();
	}
}
