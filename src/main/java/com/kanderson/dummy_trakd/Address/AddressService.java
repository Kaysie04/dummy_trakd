package com.kanderson.dummy_trakd.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanderson.dummy_trakd.NewHire.NewHire;


@Service
public class AddressService {
	
	private final AddressRepository addRepository;
	
	@Autowired
	public AddressService(AddressRepository addRepository ) {
		this.addRepository = addRepository;
	}
	
	public void createAddress(Address address) {
		addRepository.save(address);
	}
	
	
}


