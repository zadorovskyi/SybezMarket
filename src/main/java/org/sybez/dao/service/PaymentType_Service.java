package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.PaymentType;
import org.sybez.dao.repository.PaymentTypeRepository;

@Service
public class PaymentType_Service implements InterfaseForDbServices<PaymentType> {

	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	public List<PaymentType> getAll() {
		return paymentTypeRepository.findAll();
	}

	public PaymentType getById(int id) {
		return paymentTypeRepository.getOne(id);
	}

	public PaymentType addNew(PaymentType item) {
		PaymentType newPaymentType = paymentTypeRepository.save(item);
		return newPaymentType;
	}

	public void deleteById(int id) {
		paymentTypeRepository.delete(id);
	}

	public void updateItem(PaymentType t) {
		paymentTypeRepository.save(t);

	}
}
