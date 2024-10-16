package com.tanu.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tanu.entity.CitizenPlans;
import com.tanu.repository.CitizenPlansRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlansRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		//cash
		CitizenPlans c1= new CitizenPlans();
		c1.setCitizenName("John Doe");
		c1.setCitizenPhone("8978095689");
		c1.setCitizenGender("Male");
		c1.setPlansName("Cash");
		c1.setPlansStatus("Approved");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate( LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(50000);
	

		CitizenPlans c2= new CitizenPlans();
		c2.setCitizenName("Robert Brown");
		c2.setCitizenPhone("9978195680");
		c2.setCitizenGender("Male");
		c2.setPlansName("Cash");
		c2.setPlansStatus("Denied");
		c2.setDenialReason("Rental income");
		
		CitizenPlans c3= new CitizenPlans();
		c3.setCitizenName("Emily Johnson");
		c3.setCitizenPhone("1975095889");
		c3.setCitizenGender("Fe-Male");
		c3.setPlansName("Cash");
		c3.setPlansStatus("Terminated");
		c3.setStartDate(LocalDate.now().minusMonths(4));
		c3.setEndDate( LocalDate.now().plusMonths(6));
		c3.setBenefitAmount(40000);
		c3.setTerminationDate(LocalDate.now());
		c3.setTerminationReason("Employed");
	
	//food
		CitizenPlans c4= new CitizenPlans();
		c4.setCitizenName("Jane Smith");
		c4.setCitizenPhone("87978095689");
		c4.setCitizenGender("Fe-Male");
		c4.setPlansName("Food");
		c4.setPlansStatus("Approved");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate( LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(30000);
	

		CitizenPlans c5= new CitizenPlans();
		c5.setCitizenName("Jessica Lee");
		c5.setCitizenPhone("09978195680");
		c5.setCitizenGender("Fe-Male");
		c5.setPlansName("Food");
		c5.setPlansStatus("Denied");
		c5.setDenialReason("property income");
		
		CitizenPlans c6= new CitizenPlans();
		c6.setCitizenName("Michael Williams");
		c6.setCitizenPhone("6975095889");
		c6.setCitizenGender("Male");
		c6.setPlansName("Food");
		c6.setPlansStatus("Terminated");
		c6.setStartDate(LocalDate.now().minusMonths(5));
		c6.setEndDate( LocalDate.now().plusMonths(6));
		c6.setBenefitAmount(90000);
		c6.setTerminationDate(LocalDate.now());
		c6.setTerminationReason("Goverment job");
		
	 
		//medical
		CitizenPlans c7= new CitizenPlans();
		c7.setCitizenName("Christopher Martinez");
		c7.setCitizenPhone("5978095689");
		c7.setCitizenGender("Male");
		c7.setPlansName("Medical");
		c7.setPlansStatus("Approved");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate( LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(110000);
	

		CitizenPlans c8= new CitizenPlans();
		c8.setCitizenName("Daniel Hernandez");
		c8.setCitizenPhone("3978195680");
		c8.setCitizenGender("Male");
		c8.setPlansName("Medical");
		c8.setPlansStatus("Denied");
		c8.setDenialReason("Property income");
		
		CitizenPlans c9= new CitizenPlans();
		c9.setCitizenName("Sarah Wilson");
		c9.setCitizenPhone("2975095889");
		c9.setCitizenGender("Fe-Male");
		c9.setPlansName("Medical");
		c9.setPlansStatus("Terminated");
		c9.setStartDate(LocalDate.now().minusMonths(3));
		c9.setEndDate( LocalDate.now().plusMonths(6));
		c9.setBenefitAmount(20000);
		c9.setTerminationDate(LocalDate.now());
		c9.setTerminationReason("Emplyed");
		
		//Employment
		CitizenPlans c10= new CitizenPlans();
		c10.setCitizenName("Linda Thompson");
		c10.setCitizenPhone("087978095689");
		c10.setCitizenGender("Fe-Male");
		c10.setPlansName("Employment");
		c10.setPlansStatus("Approved");
		c10.setStartDate(LocalDate.now());
		c10.setEndDate( LocalDate.now().plusMonths(6));
		c10.setBenefitAmount(30000);
	

		CitizenPlans c11= new CitizenPlans();
		c11.setCitizenName("Olivia Martinez");
		c11.setCitizenPhone("09978195680");
		c11.setCitizenGender("Fe-Male");
		c11.setPlansName("Employment");
		c11.setPlansStatus("Denied");
		c11.setDenialReason("Rental income");
		
		CitizenPlans c12= new CitizenPlans();
		c12.setCitizenName("David Miller");
		c12.setCitizenPhone("6975095889");
		c12.setCitizenGender("Male");
		c12.setPlansName("Employment");
		c12.setPlansStatus("Terminated");
		c12.setStartDate(LocalDate.now().minusMonths(5));
		c12.setEndDate( LocalDate.now().plusMonths(6));
		c12.setBenefitAmount(90000);
		c12.setTerminationDate(LocalDate.now());
		c12.setTerminationReason("Goverment job");
		
		List<CitizenPlans> plans = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		repo.saveAll(plans);


	}

}
