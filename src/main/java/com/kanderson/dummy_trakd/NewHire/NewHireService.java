package com.kanderson.dummy_trakd.NewHire;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewHireService {

	// communicates with the repo to retrieve data
	
	private final NewHireRepository nhRepository;
	
	@Autowired
	public NewHireService(NewHireRepository nhRepository) {
		this.nhRepository = nhRepository;
	}
	
	public void createNewHire(NewHire nh) {
		nhRepository.save(nh);
	}
	
	public List<NewHire> getAllNewHires(){
		return nhRepository.findAll();
	}
	
	public Optional<NewHire> getNewHireById(Long nhId) {
		boolean exists = nhRepository.existsById(nhId);
		if(!exists) {
			throw new IllegalStateException("NewHire not found with given id");
		}
		return nhRepository.findById(nhId);
		
	}
	
	public void deleteNewHire(Long nhId) {
		boolean exists = nhRepository.existsById(nhId);
		if(!exists) {
			throw new IllegalStateException("NewHire not found with given id");
		}
		nhRepository.deleteById(nhId);
		
	}
	
//	public NewHire addManager(Long nhId, Long managerId){
//	Optional<NewHire> nhOptional = nhRepository.findById(nhId);
//	Optional<Manager> managerOptional = managerRepository.findById(managerId);
//	
//	if(nhOptional.isPresent()) {
//		NewHire nh = nhOptional.get();
//		Manager manager = managerOptional.get();
//		nh.setManager(manager);
//		return nhRepository.save(nh);
//	} else {
//		return null;
//	}		
//
//}
	
	
}
