package com.memorynotfound.view.person;

import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.memorynotfound.model.Person;
import com.memorynotfound.view.AbstractITextPdfView;

/*
Create By: Ron Rith
Create Date: 4/3/2018
*/
public class PersonPdfView extends AbstractITextPdfView {
    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Person> personList = (List<Person>) model.get("people");
        PdfPTable pdfTable = new PdfPTable(2);
        pdfTable.setWidths(new int[]{10,20});

        pdfTable.addCell("ID");
        pdfTable.addCell("Name");
        for(Person person: personList){
            pdfTable.addCell(person.getId().toString());
            pdfTable.addCell(person.getName());
        }

        String imageUrl = "D:\\home\\sharejee-prepare-teach\\pdf3\\pdf-content-negotiation\\src\\main\\resources\\angkor-wat.jpg";

        int indentation = 0;
        Image image = Image.getInstance(imageUrl);

        float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                - document.rightMargin() - indentation) / image.getWidth()) * 100;

        image.scalePercent(scaler);

        document.add(image);
        document.add(image);
    }
}
