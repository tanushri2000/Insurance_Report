package com.ies.service;

import java.util.List;

import com.ies.request.SearchRequest;
import com.ies.response.SearchResponse;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlansName(String planName);
	
	public List<String> getPlansStatus(String planStatus);
	
	public List<SearchResponse> search(SearchRequest searchRequest);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
}
