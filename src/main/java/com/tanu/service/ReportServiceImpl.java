package com.tanu.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tanu.entity.CitizenPlans;
import com.tanu.repository.CitizenPlansRepository;
import com.tanu.request.SearchRequest;
import com.tanu.utiles.EmailSender;
import com.tanu.utiles.ExcelGenerator;
import com.tanu.utiles.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlansRepository repo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailSender emailSender;

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

		CitizenPlans entity = new CitizenPlans();

		if (null != searchRequest.getPlansName() && !"".equals(searchRequest.getPlansName())) {
			entity.setPlansName(searchRequest.getPlansName());
		}
		if (null != searchRequest.getPlansStatus() && !"".equals(searchRequest.getPlansStatus())) {
			entity.setPlansStatus(searchRequest.getPlansStatus());
		}
		if (null != searchRequest.getCitizenGender() && !"".equals(searchRequest.getCitizenGender())) {
			entity.setCitizenGender(searchRequest.getCitizenGender());
		}
		if (null != searchRequest.getStartDate() && !"".equals(searchRequest.getStartDate())) {
			entity.setStartDate(searchRequest.getStartDate());
		}
		if (null != searchRequest.getEndDate() && !"".equals(searchRequest.getEndDate())) {
			entity.setEndDate(searchRequest.getEndDate());
		}

		return repo.findAll(Example.of(entity));

	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
        File file= new File("CitizenPlans.xlsx");
        
		List<CitizenPlans> plans = repo.findAll();
		excelGenerator.generator(response, plans,file);
		 
		String subject="Citzen plans info ";
		String body="Citizen plans excel data body attached to email";
		String to="tanushribhandare@gmail.com";
		
		emailSender.mailSender(subject, body, to, file);
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
       
		 File file= new File("CitizenPlans.pdf");
		 
		List<CitizenPlans> plans = repo.findAll();
		pdfGenerator.generator(response, plans,file); 
		
		String subject="Citzen plans info ";
		String body="Citizen plans pdf data body attached to email";
		String to="tanushribhandare@gmail.com";
		
		emailSender.mailSender(subject, body, to, file);
		return true;
	}
}
