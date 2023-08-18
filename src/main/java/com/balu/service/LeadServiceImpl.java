package com.balu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.entities.Lead;
import com.balu.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
   
	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveReg(Lead lead) {
       leadRepo.save(lead);
	}

	@Override
	public List<Lead> findAllLead() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead findLeadById(long id) {
       Optional<Lead> findById = leadRepo.findById(id);
       Lead lead = findById.get();
		return lead;
	}

	

	

}
