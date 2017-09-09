package org.sybez.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.ClientName;
import org.sybez.dao.repository.ClientNameRepository;
import org.sybez.service.editor.AllNamesEditor;

@Service
public class ClientNameService {

	@Autowired
	private ClientNameRepository clientNameRepository;
	
	public ClientName getByName(String name){
		return clientNameRepository.getByName(name);
	}
	
	 public ClientName save(String name){
		ClientName clientName = new ClientName();
		clientName.setClientName(AllNamesEditor.toFirstCapitalLetter(name));
		clientNameRepository.save(clientName);
		System.out.println(clientName);
		return clientName;
	 }
	 public ClientName save(ClientName clientName){
		clientNameRepository.save(clientName);
		return clientName;
	 }
	
}
