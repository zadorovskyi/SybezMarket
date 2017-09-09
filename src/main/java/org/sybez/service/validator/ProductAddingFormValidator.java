package org.sybez.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.sybez.dao.entity.Product;

@Component
public class ProductAddingFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	public void validate(Object target, Errors error) {
		System.out.println("validationName");
		Product product = (Product) target;
		
		if (product.getProductName().isEmpty()) {
			error.rejectValue("productName", "product.productName", "Ви не ввели назви товару");
		}
		Pattern pattern = Pattern.compile("\\d+");
		Matcher match = pattern.matcher(String.valueOf(product.getProductPrice()));
		if (!match.matches()) {
			error.rejectValue("productPrice", "Ціною товару може бути лише числове значення");
		}
		if (product.getProductPrice() <= 0) {
			error.rejectValue("productPrice", "Ви не ввели від'ємну ціни товару");
		}
		if (product.getDiscription().isEmpty()) {
			error.rejectValue("discription", "Ви не ввели опису товару");
		}
		pattern = Pattern.compile("/^(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]+)([\\/w \\.-]*)*\\/?$/");
		match = pattern.matcher(product.getImageUrl());

		if (!match.matches()) {
			error.rejectValue("imageUrl", "Ви не ввели невалідний адрес");
		}
		

	}

}
