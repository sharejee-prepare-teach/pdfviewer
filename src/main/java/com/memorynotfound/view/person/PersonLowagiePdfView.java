package com.memorynotfound.view.person;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.memorynotfound.model.Person;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/*
Create By: Ron Rith
Create Date: 4/3/2018
*/
public class PersonLowagiePdfView extends AbstractPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document, PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {

        List<Person> personList = (List<Person>) map.get("people");
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
