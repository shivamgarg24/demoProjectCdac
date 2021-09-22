package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.Model.Docs;

@Repository
public interface DocsRepository extends JpaRepository<Docs, String>{

}
