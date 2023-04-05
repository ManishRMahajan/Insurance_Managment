package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Client;
import com.test.entity.InsurancePolicy;
import com.test.serviceImpl.ClientService;
import com.test.serviceImpl.PolicyService;

@RestController
@RequestMapping("api")
public class InsurancePolicyController {

	@Autowired
	PolicyService policyService;

	@RequestMapping(value = "/policies", method = RequestMethod.GET)
	public List<InsurancePolicy> getAllPolicy() {
		return policyService.getAllPolicy();
	}

	@RequestMapping(value = "/policies/{id}", method = RequestMethod.GET)
	public InsurancePolicy getById(@PathVariable int id) {
		return policyService.getById(id);
	}

	@RequestMapping(value = "/Policies", method = RequestMethod.POST)
	public void save(@RequestBody InsurancePolicy insurancePolicy) {
		policyService.savePolicy(insurancePolicy);
	}

	@RequestMapping(value = "/Policies/{id}", method = RequestMethod.PUT)
	public InsurancePolicy update(@PathVariable int id, @RequestBody InsurancePolicy insurancePolicy) {
		return policyService.updateById(insurancePolicy, id);
	}

	@RequestMapping(value = "/Policies/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		policyService.deleteById(id);
	}

}
