package org.sybez.dao.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sybez.dao.entity.Client;
import org.sybez.dao.entity.ClientName;
import org.sybez.dao.repository.ClientNameRepository;
import org.sybez.dao.repository.ClientRepository;
import org.sybez.service.editor.AllNamesEditor;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientNameRepository clientNameRepository;
	@Autowired
	private ClientNameService clientNameService;
	@Autowired
	private BCryptPasswordEncoder passwordEcoder;

	public void saveNewClient(String name, String surname, String email, String password) {
		Client newClient = new Client();
		ClientName clientName = clientNameService.getByName(name);
		if (clientName == null) {
			clientNameService.save(name);
		}
		newClient.setClientName(clientName);
		newClient.setPassword(passwordEcoder.encode(password));
		newClient.setPhoneNumber(surname);
		newClient.seteMail(email);
		newClient.setSurname(AllNamesEditor.toFirstCapitalLetter(surname));
		clientRepository.save(newClient);
	}
	@Transactional
		public void saveNewClient(Client client) {
		client.setPassword(passwordEcoder.encode(client.getPassword()));
		client.setSurname(AllNamesEditor.toFirstCapitalLetter(client.getSurname()));
		clientNameService.save(client.getClientName());
		clientRepository.save(client);
	}

	public Client getById(int id) {
		return clientRepository.getOne(id);
	}

	public Client getByName(String name) {
		return clientRepository.findByName(name);
	}

}
