package com.kanderson.dummy_trakd.NewHire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewHireRepository extends JpaRepository<NewHire, Long> {
	
	// the purpose of the repository is to communicate with the db

}
