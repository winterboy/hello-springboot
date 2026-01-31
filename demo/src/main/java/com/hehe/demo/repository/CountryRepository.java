package com.hehe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hehe.demo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
