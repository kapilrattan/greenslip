/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.util;

import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.rsys.greenslip.phonereceipt.bo.PhoneReceiptBean;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author krattan
 */
public abstract class PDFGenerator extends PdfPageEventHelper {
public abstract String generatePDF(PhoneReceiptBean phoneReceiptBean);


    public String getRandomFileName() {
        int i = (int) (Math.random() * 10000000);
        return String.valueOf(i)+".pdf";
    }

    public String getPDFLocation() {
        String pdfLocation = "";
        String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        pdfLocation = Constants.BASE_PDF_LOCATION +  folderName;
        File directory = new File(pdfLocation);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println(pdfLocation +" : Folder/Directory is created successfully");
            } else {
                System.out.println(pdfLocation +": Directory/Folder creation failed!!!");
            }
        }

        return pdfLocation;
    }

    public String getHeader() {
        StringBuffer  heardString = new StringBuffer("");  ;
        heardString.append("<table style='width: 100%;font-size:8pt;' border='0'>");
        heardString.append("<tbody>");
        heardString.append("<tr>");
        heardString.append("<td style='width: 20%;' align='left' valign='top'><img ");
        heardString.append("src='"+PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_LOGO_FILE)+"'");
        heardString.append("width='150pt' height='100pt' /></td>");
        heardString.append("<td style='width: 40%;'>&nbsp;</td>");
        heardString.append("<td style='width: 20%;' align='left' valign='top'>");
        heardString.append("<table style='hight: 50%;' border='0' cellspacing='0' cellpadding='0'>");
        heardString.append("<tbody>");
        heardString.append("<tr>");
        heardString.append("<td style='width: 100%;' align='left' valign='top'>");
        heardString.append(PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_TEXT_LINE1));
        heardString.append("</td>");
        heardString.append("</tr>");
        heardString.append("<tr>");
        heardString.append("<td style='width: 100%;' align='left' valign='top'>");
        heardString.append(PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_TEXT_LINE2));
        heardString.append("</td>");
        heardString.append("</tr>");
        heardString.append("<tr>");
        heardString.append("<td style='width: 100%;' align='left' valign='top'>");
        heardString.append(PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_TEXT_LINE3));
        heardString.append("</td>");
        heardString.append("</tr>");
        heardString.append("<tr>");
        heardString.append("<td style='width: 100%;' align='left' valign='top'>");
        heardString.append(PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_TEXT_LINE4));
        heardString.append("</td>");
        heardString.append("</tr>");
        heardString.append("</tbody>");
        heardString.append("</table>");
        heardString.append("</td>");
        heardString.append("</tr>");
        heardString.append("<tr>");
        heardString.append("<td>Reference No __________</td>");
        heardString.append("<td>&nbsp;</td>");
        heardString.append("<td>Date __________</td>");
        heardString.append("</tr>");
        heardString.append("<tr>");
        heardString.append("<td>&nbsp;</td>");
        heardString.append("<td>&nbsp;</td>");
        heardString.append("<td>&nbsp;</td>");
        heardString.append("</tr>");
        heardString.append("</tbody>");
        heardString.append("</table>");
        return heardString.toString();
    }
}
