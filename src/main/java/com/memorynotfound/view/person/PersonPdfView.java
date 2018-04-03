package com.memorynotfound.view.person;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
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
        pdfTable.setWidths(new int[]{10,60});

        pdfTable.addCell("ID");
        pdfTable.addCell("Name");
        for(Person person: personList){
            pdfTable.addCell(person.getId().toString());
            pdfTable.addCell(person.getName());
        }
        document.add(pdfTable);
    }
}
