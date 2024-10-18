package com.tanu.utiles;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tanu.entity.CitizenPlans;
import com.tanu.repository.CitizenPlansRepository;

@Controller
public class ExcelGenerator {

	@Autowired
	private CitizenPlansRepository repo;

	public void generator(HttpServletResponse response,List<CitizenPlans> plans,  File file) throws Exception {

		// create workbook
		Workbook workbook = new XSSFWorkbook();
		// create sheet
		Sheet sheet = workbook.createSheet("Citizen-Data");
		// create rows
		Row headerRow = sheet.createRow(0);
		// create cells
		headerRow.createCell(0).setCellValue("citizenId");
		headerRow.createCell(1).setCellValue("citizenName");
		headerRow.createCell(2).setCellValue("citizenGender");
		headerRow.createCell(3).setCellValue("citizenPhone");
		headerRow.createCell(4).setCellValue("PlansName");
		headerRow.createCell(5).setCellValue("PlansStatus");
		headerRow.createCell(6).setCellValue("StartDate");
		headerRow.createCell(7).setCellValue("EndDate");
		headerRow.createCell(8).setCellValue("BenefitAmount");



		int dataRowIndex = 1;
		// set data into cells
		for (CitizenPlans plan : plans) {

			Row dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getCitizenGender());
			dataRow.createCell(3).setCellValue(plan.getCitizenPhone());
			dataRow.createCell(4).setCellValue(plan.getPlansName());
			dataRow.createCell(5).setCellValue(plan.getPlansStatus());

			if (null != plan.getStartDate()) {
				dataRow.createCell(6).setCellValue(plan.getStartDate() + "");
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}

			if (null != plan.getEndDate()) {
				dataRow.createCell(7).setCellValue(plan.getEndDate() + "");
			} else {
				dataRow.createCell(7).setCellValue("N/A");
			}

			if (null != plan.getBenefitAmount()) {
				dataRow.createCell(8).setCellValue(plan.getBenefitAmount());
			} else {
				dataRow.createCell(8).setCellValue("N/A");
			}
			dataRowIndex++;
		}
		
		//send to email (fos it will create excel in current folder)
		FileOutputStream fos= new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		//send to browser(sos it will create excel in browser)
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}
