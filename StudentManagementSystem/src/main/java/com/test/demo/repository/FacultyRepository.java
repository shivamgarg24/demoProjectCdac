package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{

	
}