package com.tanu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tanu.entity.CitizenPlans;
import com.tanu.repository.CitizenPlansRepository;
import com.tanu.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlansRepository repo;

	@Override
	public List<String> getPlansName() {
		List<String> plansName = repo.plansName();
		return plansName;
	}

	@Override
	public List<String> getPlansStatus() {
	List<String> plansStatus = repo.plansStatus();
		return plansStatus;
	}

	@Override
	public List<CitizenPlans> search(SearchRequest searchRequest) {
		
		  CitizenPlans entity=new CitizenPlans();
		  
		  if(null!=searchRequest.getPlansName() && !"".equals(searchRequest.getPlansName())) {
			  entity.setPlansName(searchRequest.getPlansName());
		  }
		  if(null!=searchRequest.getPlansStatus() && !"".equals(searchRequest.getPlansStatus())) {
			  entity.setPlansStatus(searchRequest.getPlansStatus());
		  }
		  if(null!=searchRequest.getCitizenGender() && !"".equals(searchRequest.getCitizenGender())) {
			  entity.setCitizenGender(searchRequest.getCitizenGender());
		  }
		  if(null!=searchRequest.getStartDate() && !"".equals(searchRequest.getStartDate())) {
			   entity.setStartDate(searchRequest.getStartDate());
		  }
		  if(null!=searchRequest.getEndDate() && !"".equals(searchRequest.getEndDate())) {
			  entity.setEndDate(searchRequest.getEndDate());
		  }
		  
		  return repo.findAll(Example.of(entity));
		 
		
	}

	@Override
	public boolean excelGenerator() {
	
		return false;
	}

	@Override
	public boolean pdfGeneratora() {
		
		return false;
	}

}
