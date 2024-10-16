package com.tanu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tanu.entity.CitizenPlans;
import com.tanu.request.SearchRequest;
import com.tanu.service.ReportServiceImpl;



@Controller
public class ReportController {
	
	@Autowired
	private ReportServiceImpl service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		
		return "index";
	}
	private void init(Model model) {
	
		model.addAttribute("names", service.getPlansName());
		model.addAttribute("status", service.getPlansStatus());
	}
	@PostMapping("/search")
	public String searchHandler(@ModelAttribute("search") SearchRequest searchRequest,Model model) {
		
		init(model);
		List<CitizenPlans> plansList = service.search(searchRequest);
		model.addAttribute("plansList", plansList);
		return "index";
	}
	
	

}