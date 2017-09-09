package org.sybez.service.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.sybez.dao.entity.ClientName;

@Component
public class ClientNameValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		System.out.println("validator suports");
		return ClientName.class.equals(clazz);
	}

	public void validate(Object target, Errors error) {
		ClientName clientName = (ClientName) target;
		if (clientName.getClientName().isEmpty()) 
			error.rejectValue("clientName", "clientName.clientName", "fild blank");
		}
		
}
