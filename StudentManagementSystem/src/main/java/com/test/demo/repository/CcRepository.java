package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.Model.Cc;

@Repository
public interface CcRepository extends JpaRepository<Cc, Long>{

}
