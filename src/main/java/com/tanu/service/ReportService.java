package com.tanu.service;

import java.util.List;

import com.tanu.entity.CitizenPlans;
import com.tanu.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlansName();
	public List<String> getPlansStatus();
	public List<CitizenPlans> search(SearchRequest searchRequest);
	public boolean excelGenerator();
	public boolean pdfGeneratora();

}
