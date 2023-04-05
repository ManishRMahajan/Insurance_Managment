package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

}
