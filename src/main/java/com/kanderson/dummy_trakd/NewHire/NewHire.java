package com.kanderson.dummy_trakd.NewHire;

import java.io.Serializable;

import com.kanderson.dummy_trakd.Address.Address;
import com.kanderson.dummy_trakd.Dept.Dept;
import com.kanderson.dummy_trakd.Manager.Manager;

import jakarta.persistence.*;




@Entity
@Table
public class NewHire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "salary")
	private String salary;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Dept dept;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "NewHire [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", jobTitle="
				+ jobTitle + ", salary=" + salary + ", address=" + address + ", manager=" + manager + ", dept=" + dept
				+ "]";
	}
	
	
	
	
	
	

}
