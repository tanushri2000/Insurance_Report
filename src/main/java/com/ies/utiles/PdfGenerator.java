package com.ies.utiles;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ies.entity.ApplicationEntity;
import com.ies.entity.EligEntity;
import com.ies.repository.EligRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
	@Autowired
	private EligRepository eligRepo;


	public void generator(HttpServletResponse response,File file) throws Exception {
		
		List<EligEntity> aligEntities = eligRepo.findAll();
		LocalDate eligEndDate=null; 
		LocalDate eligStartDate=null;
		Double benefitAmt=0
		for(EligEntity elig: aligEntities) {
			eligEndDate = elig.getEligEndDate();
			LocalDate eligStartDate = elig.getEligStartDate();
			Double benefitAmt = elig.getBenefitAmt();
		}
		// create document object
		Document document = new Document(PageSize.A4);
	
		//document create in current filder
		PdfWriter.getInstance(document, new FileOutputStream(file));

		// documents attach to browser as response
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		// add font
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(12);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Citizen Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(9);

		// space and width in between table and paragraph
		table.setSpacingBefore(10);
		table.setWidthPercentage(100f);

		
		table.addCell("citizen Name");
		table.addCell("citizenGender");
		table.addCell("citizenPhone");
		table.addCell("PlansName");
		table.addCell("PlansStatus");
		table.addCell("EligStartDate");
		table.addCell("EligEndDate");
		table.addCell("BenefitAmount");

			table.addCell(appEntity.getFullname());
			table.addCell(appEntity.getGender());
			table.addCell(appEntity.getPhone());
			table.addCell(aligEntities.g);
			table.addCell(eligEntity.getPlanStatus());

			if (null != eligEntity.getEligStartDate()) {
				table.addCell(eligEntity.getEligStartDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != eligEntity.getEligEndDate()) {
				table.addCell(eligEntity.getEligEndDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != eligEntity.getBenefitAmt()) {
				table.addCell(String.valueOf(eligEntity.getBenefitAmt()));
			} else {
				table.addCell("N/A");
			}
		

		document.add(table);
		document.close();
	}
}
