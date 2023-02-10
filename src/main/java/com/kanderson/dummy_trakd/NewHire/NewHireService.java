package com.kanderson.dummy_trakd.NewHire;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanderson.dummy_trakd.Address.Address;
import com.kanderson.dummy_trakd.Address.AddressRepository;
import com.kanderson.dummy_trakd.Dept.Dept;
import com.kanderson.dummy_trakd.Dept.DeptRepository;
import com.kanderson.dummy_trakd.Manager.Manager;
import com.kanderson.dummy_trakd.Manager.ManagerRepository;

@Service
public class NewHireService {

	// communicates with the repo to retrieve data
	
	private final NewHireRepository nhRepository;
	private final ManagerRepository managerRepository;
	private final DeptRepository deptRepository;
	private final AddressRepository addRepository;
	
	@Autowired
	public NewHireService(NewHireRepository nhRepository, ManagerRepository managerRepository,DeptRepository deptRepository, AddressRepository addRepository ) {
		this.nhRepository = nhRepository;
		this.managerRepository = managerRepository;
		this.deptRepository = deptRepository;
		this.addRepository = addRepository;
	}
	
	
	
	public void createNewHire(NewHire nh) {
		nhRepository.save(nh);
	}
	
	public List<NewHire> getAllNewHires(){
		return nhRepository.findAll();
	}
	
	public NewHire getNewHireById(Long nhId) {
		boolean exists = nhRepository.existsById(nhId);
		if(!exists) {
			throw new IllegalStateException("NewHire not found with given id");
		}
		else {
			Optional<NewHire> nhOptional = nhRepository.findById(nhId);
			NewHire nh = nhOptional.get();
			return nh;
		} 
	}
	
	public void deleteNewHire(Long nhId) {
		boolean exists = nhRepository.existsById(nhId);
		if(!exists) {
			throw new IllegalStateException("NewHire not found with given id");
		}
		nhRepository.deleteById(nhId);	
	}
	
	public NewHire addAddress(Long nhId, Long addId) {
		Optional<NewHire> nhOptional = nhRepository.findById(nhId);
		Optional<Address> addOptional = addRepository.findById(addId);
		
		if(nhOptional.isPresent() && addOptional.isPresent()) {
			NewHire nh = nhOptional.get();
			Address address = addOptional.get();
			nh.setAddress(address);
			return nhRepository.save(nh);
		} else {
			return null;
		}	
	}
	
	
	
	public NewHire addManager(Long nhId, Long managerId) {
		Optional<NewHire> nhOptional = nhRepository.findById(nhId);
		Optional<Manager> managerOptional = managerRepository.findById(managerId);
		
		if(nhOptional.isPresent()) {
			NewHire nh = nhOptional.get();
			Manager manager = managerOptional.get();
			nh.setManager(manager);
			return nhRepository.save(nh);
		} else {
			return null;
		}
		
	}
	
	public NewHire addDept(Long nhId, Long deptId) {
		Optional<NewHire> nhOptional = nhRepository.findById(nhId);
		Optional<Dept> deptOptional = deptRepository.findById(deptId);
		if(nhOptional.isPresent()) {
			NewHire nh = nhOptional.get();
			Dept dept = deptOptional.get();
			nh.setDept(dept);
			return nhRepository.save(nh);
		} else {
			return null;
		}
		
	}
	

}
	
	

