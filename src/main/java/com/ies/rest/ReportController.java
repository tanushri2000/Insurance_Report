package com.ies.rest;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ies.entity.CitizenPlans;
import com.ies.request.SearchRequest;
import com.ies.service.ReportService;



@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception {
		
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=citizenPlans.xlsx");
		service.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=citizenPlans.pdf");
		service.exportPdf(response);
	}
	
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
