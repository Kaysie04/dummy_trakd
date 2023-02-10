package com.kanderson.dummy_trakd.NewHire;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewHireRepository extends JpaRepository<NewHire, Long> {

	Optional<NewHire> findById(int nhId);
	
	// the purpose of the repository is to communicate with the db

}
