package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.Order_;
import org.sybez.dao.repository.OrderRepository;

@Service
public class Order_Service implements InterfaseForDbServices<Order_> {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order_> getAll() {
		return orderRepository.findAll();
	}

	public Order_ getById(int id) {
		return orderRepository.getOne(id);
	}

	public Order_ addNew(Order_ item) {
		Order_ newOrder = orderRepository.save(item);
		return newOrder;
	}

	public void deleteById(int id) {
		orderRepository.delete(id);
	}

	public void updateItem(Order_ t) {
		orderRepository.save(t);
	}

}
