package com.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Client;
import com.test.repo.ClientRepo;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

	@Autowired
	ClientRepo clientrepo;

	public void saveClient(Client client) {
		clientrepo.save(client);
	}

	public Client getById(int id) {
		return clientrepo.getById(id);
	}

	public void deteteById(int id) {
		clientrepo.deleteById(id);
	}

	@Transactional
	public Client updateById(Client client, int id) {
		clientrepo.findById(id) // returns Optional<User>
				.ifPresent(newClient -> {
					newClient.setName(client.getName());
					newClient.setAddress(client.getAddress());
					newClient.setContactInformation(client.getContactInformation());
					newClient.setDateOfBirth(client.getDateOfBirth());
					newClient.setInsurancepolicy(client.getInsurancepolicy());

					clientrepo.save(newClient);
				});
		Optional<Client> newClient = clientrepo.findById(id);

		return newClient.isPresent() ? newClient.get() : null;
	}

	public List<Client> getAllClients() {
		return clientrepo.findAll();
	}

	public void deleteById(int id) {
		clientrepo.deleteById(id);
	}

}
