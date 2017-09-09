package org.sybez.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.sybez.dao.entity.Client;

@Component
public class RegistrationValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		System.out.println("validator suports");
		return Client.class.equals(clazz);

	}

	public void validate(Object target, Errors error) {
		System.out.println("validator validate");
		Client client = (Client) target;
		if (client.getClientName()==null) 
			error.rejectValue("clientName", "client.clientName", "fild blank");
			if (client.getPassword().isEmpty()) 
				error.rejectValue("password", "client.password", "Field password can not by empty");
			if (client.getSurname().isEmpty()) 
				error.rejectValue("surname", "client.surname", "Field Surname can not by empty");
			Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(client.geteMail());
			if (!matcher.find()) {
				error.rejectValue("eMail", "client.eMail", "Field eMail is not valid");
				if (client.geteMail().isEmpty()) 
					error.rejectValue("eMail", "client.eMail", "Field eMail can not by empty");
			}
	}
}
