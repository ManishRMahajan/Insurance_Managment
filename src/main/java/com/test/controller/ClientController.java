package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Client;
import com.test.serviceImpl.ClientService;

@RestController
@RequestMapping("api")
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClients(@RequestBody Client client) {
		return clientService.getAllClients();
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Client getById(@PathVariable int id) {
		return clientService.getById(id);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public void save(@RequestBody Client client) {
		clientService.saveClient(client);
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	public Client update(@PathVariable int id, @RequestBody Client client) {
		return clientService.updateById(client, id);
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		clientService.deleteById(id);
	}

}
