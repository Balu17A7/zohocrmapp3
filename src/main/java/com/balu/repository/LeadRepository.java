package com.balu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balu.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
