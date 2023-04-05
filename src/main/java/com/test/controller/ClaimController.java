package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Claim;
import com.test.entity.Client;
import com.test.serviceImpl.ClaimService;
import com.test.serviceImpl.ClientService;

@RestController
@RequestMapping("api")

public class ClaimController {

	@Autowired
	ClaimService claimService;

	@RequestMapping(value = "/claims", method = RequestMethod.GET)
	public List<Claim> getAllClients(@RequestBody Client client) {
		return claimService.getAllClaims();
	}

	@RequestMapping(value = "/claims/{id}", method = RequestMethod.GET)
	public Claim getById(@PathVariable int id) {
		return claimService.getById(id);
	}

	@RequestMapping(value = "/claims", method = RequestMethod.POST)
	public void save(@RequestBody Claim claim) {
		claimService.save(claim);
	}

	@RequestMapping(value = "/claims/{id}", method = RequestMethod.PUT)
	public Claim update(@PathVariable int id, @RequestBody Claim claim) {
		return claimService.updateById(claim, id);
	}

	@RequestMapping(value = "/claims/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		claimService.deleteById(id);
	}

}
