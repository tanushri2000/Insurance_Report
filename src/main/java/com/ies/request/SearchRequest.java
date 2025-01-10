package com.ies.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
	
	private String planName;
	private String planStatus;
	private LocalDate eligStartDate;
	private LocalDate eligEndDate;

}
