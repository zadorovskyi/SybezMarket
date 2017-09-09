package org.sybez.dao.service;

import java.util.List;

public interface InterfaseForDbServices<T> {

	public List<T> getAll();
	public T  getById(int id);
	public T addNew(T item);
	public void deleteById(int id);
	public void updateItem(T item);
	

	
}
