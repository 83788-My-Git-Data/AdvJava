package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Guest;

public interface GuestDao extends JpaRepository<Guest, Long>{

//	Optional<Guest> findByFirstNameAndLastName(String firstName, String lastName);
	Optional<Guest> findByFirstName(String firstName);
}
