package org.sybez.service.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.sybez.dao.entity.ClientName;
import org.sybez.dao.service.ClientNameService;

public class ClientNameEditor extends PropertyEditorSupport {
	
	@Autowired
	@Qualifier("registrationValidator")
	Validator validator;
	private final ClientNameService clientNameService;
	
	public ClientNameEditor(ClientNameService clientNameService){
		this.clientNameService = clientNameService;
	}

public void setAsText(String text) throws IllegalArgumentException{
	if(!text.isEmpty()){
	ClientName existingClientName = clientNameService.getByName(text);
	if (existingClientName == null) {
		existingClientName = new ClientName();
		existingClientName.setClientName(text);
	}
	setValue(existingClientName);
}
	return;
}
	
}
