package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Claim;

public interface ClaimRepo extends JpaRepository<Claim, Integer> {

}
