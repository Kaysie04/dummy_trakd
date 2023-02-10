package com.kanderson.dummy_trakd.Dept;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Long> {

	Optional<Dept> findById(int deptId);

}
