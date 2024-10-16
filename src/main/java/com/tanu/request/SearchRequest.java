package com.tanu.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
	
	private String plansName;
	private String plansStatus;
	private String citizenGender;
	private LocalDate startDate;
	private LocalDate endDate;

}
