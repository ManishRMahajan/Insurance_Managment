package com.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Client;
import com.test.entity.InsurancePolicy;
import com.test.repo.ClientRepo;
import com.test.repo.InsurancePolicyRepo;

import jakarta.transaction.Transactional;

@Service
public class PolicyService {

	@Autowired
	InsurancePolicyRepo insurancePolicyRepo;

	public void savePolicy(InsurancePolicy policy) {
		insurancePolicyRepo.save(policy);
	}

	public InsurancePolicy getById(int id) {
		return insurancePolicyRepo.getById(id);
	}

	public void deteteById(int id) {
		insurancePolicyRepo.deleteById(id);
	}

	@Transactional
	public InsurancePolicy updateById(InsurancePolicy policy, int id) {
		insurancePolicyRepo.findById(id) // returns Optional<User>
				.ifPresent(newPolicy -> {
					newPolicy.setClaim(policy.getClaim());
					newPolicy.setClient(policy.getClient());
					newPolicy.setCoverageAmount(policy.getCoverageAmount());
					newPolicy.setEndDate(policy.getEndDate());
					newPolicy.setPolicyNumber(policy.getPolicyNumber());
					newPolicy.setPremium(policy.getPremium());
					newPolicy.setStartDate(policy.getStartDate());
					newPolicy.setType(policy.getType());

					insurancePolicyRepo.save(newPolicy);
				});
		Optional<InsurancePolicy> newPolicy = insurancePolicyRepo.findById(id);

		return newPolicy.isPresent() ? newPolicy.get() : null;
	}

	public List<InsurancePolicy> getAllPolicy() {
		return insurancePolicyRepo.findAll();
	}

	public void deleteById(int id) {
		insurancePolicyRepo.deleteById(id);
	}

}
