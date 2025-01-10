package com.ies.service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ies.entity.EligEntity;
import com.ies.repository.EligRepository;
import com.ies.repository.PlanRepository;
import com.ies.request.SearchRequest;
import com.ies.response.SearchResponse;
import com.ies.utiles.EmailSender;
import com.ies.utiles.ExcelGenerator;
import com.ies.utiles.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EligRepository eligRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private PlanRepository planRepo;
	
	

	public List<String> getPlansName(String planName) {
		return planRepo.findByPlanName(planName);
		 
		
	}

	@Override
	public List<String> getPlansStatus(String planStatus) {
		return eligRepo.findByPlanStatus(planStatus);
		
	}

	@Override
	public List<SearchResponse> search(SearchRequest searchRequest) {

		List<SearchResponse> response = new ArrayList<>();

		EligEntity queryBuilder = new EligEntity();

		String planName = searchRequest.getPlanName();
		if (planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = searchRequest.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}

		LocalDate planStartDate = searchRequest.getEligStartDate();
		if (planStartDate != null) {
			queryBuilder.setEligStartDate(planStartDate);
		}

		LocalDate planEndDate = searchRequest.getEligEndDate();
		if (planEndDate != null) {
			queryBuilder.setEligEndDate(planEndDate);
		}
		
		Example<EligEntity> example = Example.of(queryBuilder);

		List<EligEntity> entities = eligRepo.findAll(example);

		for (EligEntity entity : entities) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(entity, sr);
			response.add(sr);
		}

		return response;

	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
        File file= new File("CitizensReport.xlsx");
        
		List<EligEntity> plans = eligRepo.findAll();
		excelGenerator.generator(response, plans,file);
		 
		String subject="Citzen plans info ";
		String body="Citizen plans excel data body attached to email";
		String to="tanushribhandare@gmail.com";
		
		emailSender.mailSender(subject, body, to, file);
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
       
		 File file= new File("CitizensReport.pdf");
		 
		 List<EligEntity> plans = eligRepo.findAll();
		pdfGenerator.generator(response, plans, file);
		
		String subject="Citzen plans info ";
		String body="Citizen plans pdf data body attached to email";
		String to="tanushribhandare@gmail.com";
		
		emailSender.mailSender(subject, body, to, file);
		return true;
	}
}
