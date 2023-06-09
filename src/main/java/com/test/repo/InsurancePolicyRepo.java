package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.InsurancePolicy;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Integer> {

}
