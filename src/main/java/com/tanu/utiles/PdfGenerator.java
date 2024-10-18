package com.tanu.utiles;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tanu.entity.CitizenPlans;
import com.tanu.repository.CitizenPlansRepository;

@Component
public class PdfGenerator {
	
	@Autowired
	private CitizenPlansRepository repo;


	public void generator(HttpServletResponse response, List<CitizenPlans> plans,File file) throws Exception {
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

		Paragraph p = new Paragraph("Citizen plans", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(9);

		// space and width in between table and paragraph
		table.setSpacingBefore(10);
		table.setWidthPercentage(100f);

		table.addCell("citizenId");
		table.addCell("citizenName");
		table.addCell("citizenGender");
		table.addCell("citizenPhone");
		table.addCell("PlansName");
		table.addCell("PlansStatus");
		table.addCell("StartDate");
		table.addCell("EndDate");
		table.addCell("BenefitAmount");

		

		for (CitizenPlans plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenGender());
			table.addCell(plan.getCitizenPhone());
			table.addCell(plan.getPlansName());
			table.addCell(plan.getPlansStatus());

			if (null != plan.getStartDate()) {
				table.addCell(plan.getStartDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != plan.getEndDate()) {
				table.addCell(plan.getEndDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != plan.getBenefitAmount()) {
				table.addCell(String.valueOf(plan.getBenefitAmount()));
			} else {
				table.addCell("N/A");
			}
		}

		document.add(table);
		document.close();
	}
}
