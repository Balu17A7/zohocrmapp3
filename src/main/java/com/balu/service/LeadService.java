package com.balu.service;

import java.util.List;

import com.balu.entities.Lead;

public interface LeadService {
	
	public void saveReg(Lead lead);

	public List<Lead> findAllLead();

	public void deleteLeadById(long id);


	public Lead findLeadById(long id);

	
}


