package com.ies.response;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
	
	private String fullname;
	private Long mobile;
	private String email;
	private String gender;
	private Long ssn;

}
