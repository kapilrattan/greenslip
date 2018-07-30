/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.util;

import com.rsys.greenslip.phonereceipt.bo.PhoneReceiptBean;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author krattan
 */
public class PDFGenerator {

    public String generatePDF(PhoneReceiptBean phoneReceiptBean) {
        String pdfFileName = getRandomFileName();
        String pdfFilePath = getPDFLocation() + File.separator + pdfFileName;
        System.out.println("PDF path [" + pdfFilePath + "]");
        try {
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDFont font = PDType1Font.HELVETICA_BOLD;
            try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
                contents.beginText();
                contents.setFont(font, 12);
                contents.newLineAtOffset(100, 700);
                contents.showText("Hello World !!!!");
                contents.endText();
            }
            doc.save(pdfFilePath);
            System.out.println(pdfFilePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        
        
        
        
        
        
        
        
        
        
        
        
        return pdfFilePath;
    }

    private String getRandomFileName() {
        int i = (int) (Math.random() * 10000000);
        return String.valueOf(i);
    }

    private String getPDFLocation() {
        String pdfLocation = "";
        Date today = new Date();
        String folderName = String.valueOf(today.getYear()) + String.valueOf(today.getMonth()) + String.valueOf(today.getDate());
        pdfLocation = Constants.BASE_PDF_LOCATION + File.separator + folderName;
        File directory = new File(pdfLocation);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println(pdfLocation +" : Folder/Directory is created successfully");
            } else {
                System.out.println(pdfLocation +": Directory/Folder creation failed!!!");
            }
        }

        return pdfLocation;
    }
}
