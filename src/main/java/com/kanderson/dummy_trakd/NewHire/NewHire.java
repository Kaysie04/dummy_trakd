package com.kanderson.dummy_trakd.NewHire;

import java.io.Serializable;
import java.util.Objects;

import com.kanderson.dummy_trakd.Address.Address;
import com.kanderson.dummy_trakd.Dept.Dept;
import com.kanderson.dummy_trakd.Manager.Manager;

import jakarta.persistence.*;




@Entity
@Table(name = "newhire")
public class NewHire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "employeeId")
	private int employeeId;
	
	@Column(name = "name")
	private String name;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "salary")
	private String salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private Manager manager;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewHire newHire = (NewHire) o;
		return employeeId == newHire.employeeId && Objects.equals(id, newHire.id) && Objects.equals(name, newHire.name) && Objects.equals(email, newHire.email) && Objects.equals(password, newHire.password) && Objects.equals(jobTitle, newHire.jobTitle) && Objects.equals(salary, newHire.salary) && Objects.equals(address, newHire.address) && Objects.equals(manager, newHire.manager) && Objects.equals(dept, newHire.dept);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, employeeId, name, email, password, jobTitle, salary, address, manager, dept);
	}

	@Override
	public String toString() {
		return "NewHire{" +
				"id=" + id +
				", employeeId=" + employeeId +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", jobTitle='" + jobTitle + '\'' +
				", salary='" + salary + '\'' +
				", address=" + address +
				", manager=" + manager +
				", dept=" + dept +
				'}';
	}
}
