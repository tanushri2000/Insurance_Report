package com.ies.utiles;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ies.entity.ApplicationEntity;
import com.ies.entity.EligEntity;
import com.ies.repository.EligRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	@Autowired
	private EligRepository eligRepo;

	public void generator(HttpServletResponse response,EligEntity eligEntity,ApplicationEntity appEntity,  File file) throws Exception {

		// create workbook
		Workbook workbook = new XSSFWorkbook();
		// create sheet
		Sheet sheet = workbook.createSheet("Citizens-Data");
		// create rows
		Row headerRow = sheet.createRow(0);
		// create cells
		headerRow.createCell(0).setCellValue("citizen Name");
		headerRow.createCell(1).setCellValue("citizenGender");
		headerRow.createCell(2).setCellValue("citizenPhone");
		headerRow.createCell(4).setCellValue("PlansName");
		headerRow.createCell(5).setCellValue("PlansStatus");
		headerRow.createCell(6).setCellValue("EligStartDate");
		headerRow.createCell(7).setCellValue("EligEndDate");
		headerRow.createCell(8).setCellValue("BenefitAmount");



		int dataRowIndex = 1;
		// set data into cells
		

			Row dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(appEntity.getFullname());
			dataRow.createCell(1).setCellValue(appEntity.getGender());
			dataRow.createCell(2).setCellValue(appEntity.getPhone());
			dataRow.createCell(3).setCellValue(eligEntity.getPlanName());
			dataRow.createCell(4).setCellValue(eligEntity.getPlanStatus());
		


			if (null != eligEntity.getEligStartDate()) {
				dataRow.createCell(6).setCellValue(eligEntity.getEligStartDate() + "" + "");
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}

			if (null != eligEntity.getEligEndDate()) {
				dataRow.createCell(7).setCellValue(eligEntity.getEligEndDate()+ "");
			} else {
				dataRow.createCell(7).setCellValue("N/A");
			}

			if (null != eligEntity.getBenefitAmt()) {
				dataRow.createCell(8).setCellValue(String.valueOf(eligEntity.getBenefitAmt()));
			} else {
				dataRow.createCell(8).setCellValue("N/A");
			}
			dataRowIndex++;
		
		
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
