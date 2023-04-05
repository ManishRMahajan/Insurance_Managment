package com.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Claim;
import com.test.repo.ClaimRepo;

import jakarta.transaction.Transactional;

@Service
public class ClaimService {

	@Autowired
	ClaimRepo claimRepo;

	public void save(Claim claim) {
		claimRepo.save(claim);
	}

	public Claim getById(int id) {
		return claimRepo.getById(id);
	}

	public void deteteById(int id) {
		claimRepo.deleteById(id);
	}

	@Transactional
	public Claim updateById(Claim claim, int id) {
		claimRepo.findById(id) // returns Optional<User>
				.ifPresent(newclaim -> {
					newclaim.setClaimStatus(claim.getClaimStatus());
					newclaim.setDate(claim.getDate());
					newclaim.setDescdription(claim.getDescdription());
					newclaim.setInsurancePolicy(claim.getInsurancePolicy());

					claimRepo.save(newclaim);
				});
		Optional<Claim> newClaim = claimRepo.findById(id);

		return newClaim.isPresent() ? newClaim.get() : null;
	}

	public List<Claim> getAllClaims() {
		return claimRepo.findAll();
	}

	public void deleteById(int id) {
		claimRepo.deleteById(id);
	}

}
