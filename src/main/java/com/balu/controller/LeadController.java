package com.balu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balu.dto.LeadDto;
import com.balu.entities.Lead;
import com.balu.service.LeadService;
import com.balu.util.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/balu")
	public String createOneNewLead() {
		return "Create_Lead";
	}

	@RequestMapping("/saveReg")
	public String saveOnelead(@ModelAttribute Lead lead, Model model) {
		model.addAttribute("msg", "Lead Saved");
		leadService.saveReg(lead);
		emailService.sendEmail(lead.getEmail(), "text", "Testing Email Services");
		return "Create_Lead";

}
//	@RequestMapping("/saveReg")
//	public String saveOnelead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile, ModelMap model ) {
//		Lead  l = new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//	    l.setMobile(mobile);
//	    
//	    model.addAttribute("Msg", "Lead is Saved!!");
//		leadService.saveReg(l);
//		return "Create_Lead";
//	}
//	@RequestMapping("/saveReg")
//	public String saveOnelead(LeadDto dto, Model model) {
//		Lead lead = new Lead();
//		lead.setFirstName(dto.getFirstName());
//		lead.setLastName(dto.getLastName());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//       model.addAttribute("Msg", "Lead is Saved!!");
//
//		leadService.saveReg(lead);
//		return "Create_Lead";
//}
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		System.out.println(leads);
		return "List_Leads";
	}
	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam ("id") long id, Model model) {
        leadService.deleteLeadById(id);
        
        List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		return "List_Leads";
	}
	
	@RequestMapping("/update")
	public String updateLeadById(@RequestParam ("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return"Update_Lead";
	}
	@RequestMapping("/editReg")
	public String editReg(LeadDto dto, Model model) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadService.saveReg(lead);
		
		List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		return "List_Leads";
		
		
	}
	 
}