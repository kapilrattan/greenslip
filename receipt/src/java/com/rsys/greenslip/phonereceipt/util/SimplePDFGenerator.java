/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.rsys.greenslip.phonereceipt.bo.PhoneReceiptBean;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;

public class SimplePDFGenerator extends PDFGenerator {

    public String generatePDF(PhoneReceiptBean phoneReceiptBean) {
        String pdfFileName = getRandomFileName();
        String pdfFilePath = getPDFLocation() + "/" + pdfFileName;
        try {
            String contentString = getContent(phoneReceiptBean);
            PdfWriter writer;
            Document document = new Document();
            writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
            writer.setViewerPreferences(PdfWriter.PageLayoutOneColumn);
            writer.setPageEvent(new SimplePDFGenerator());
            document.setMargins(36, 36, 36, 54);
            // step 3:
            document.open();
/*
            String headerString = getHeader();
            StringReader header = new StringReader(headerString);
            List<Element> headerElements = HTMLWorker.parseToList(header, null);
            for (Element element : headerElements) {
                document.add(element);
            }
*/
            StringReader reader = new StringReader(contentString);

            List<Element> elements = HTMLWorker.parseToList(reader, null);

            for (Element element : elements) {
                document.add(element);
            }

            document.close();
            writer.close();

            System.out.println("PDF File Generated: " + pdfFilePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pdfFilePath;
    }
    /*
     private String getContent(PhoneReceiptBean phoneReceiptBean) {
     StringBuffer contentString = new StringBuffer("");
     contentString.append("<table style='width: 100%;font-size:8pt;' border='0'>");
     contentString.append("<tbody>");
     contentString.append("<tr>");
     contentString.append("<td>Receipt Number: </td>");
     contentString.append("<td>&nbsp;</td>");
     contentString.append("<td>Date: </td>");
     contentString.append("<td>" + phoneReceiptBean.getTradeDate() + "</td>");
     contentString.append("</tr>");
     contentString.append("<tr>");
     contentString.append("<td>&nbsp;</td>");
     contentString.append("<td>&nbsp;</td>");
     contentString.append("<td>&nbsp;</td>");
     contentString.append("<td>&nbsp;</td>");
     contentString.append("</tr>");
     contentString.append("</tbody>");
     contentString.append("</table>");
     return contentString.toString();
     }
     */

    private String getContent(PhoneReceiptBean phoneReceiptBean) {
        StringBuffer contentString = new StringBuffer("");
        contentString.append("<table border='0' align='center' cellpadding='10' cellspacing='2'>");
        contentString.append("<tr>");
        contentString.append("<td colspan='4'><img width='400px' height='200px' src=" + phoneReceiptBean.getLogoLocation() + "></img></td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td>Store</td><td><b>" + phoneReceiptBean.getStoreName() + "</b></td>");
        contentString.append("<td>Date</td><td><b>" + phoneReceiptBean.getTradeDate() + "</b></td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td>Phone Make</td><td><b>" + phoneReceiptBean.getPhoneMake() + "</b></td>");
        contentString.append("<td>Phone Model</td><td><b>" + phoneReceiptBean.getPhoneModel() + "</b></td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td>Phone Condition</td><td><b>" + phoneReceiptBean.getPhoneCondition() + "</b></td>");
        contentString.append("<td>IMEI Number</td><td><b>" + phoneReceiptBean.getPhoneModel() + "</b></td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td>Seller Name</td><td><b>" + phoneReceiptBean.getSellerName() + "</b></td>");
        contentString.append("<td>Contact Number</td><td><b>" + phoneReceiptBean.getSellerContactNumber() + "</b></td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td>Email Id</td><td><b>" + phoneReceiptBean.getSellerEmailId() + "</b></td>");
        contentString.append("<td>&nbsp;</td><td>&nbsp;</td>");
        contentString.append("</tr>");
        contentString.append("<tr>");
        contentString.append("<td colspan='2'>");
        contentString.append("<img src=" + phoneReceiptBean.getPhotoIdInternalPath()+ " alt='Photo Id'/>");
        contentString.append("</td>");
        contentString.append("<td colspan='2'>");
        contentString.append("<img src=" + phoneReceiptBean.getSignatureInternalPath() + " alt='Photo Id'/>");
        contentString.append("</td>");
        contentString.append("</tr>");
        contentString.append("</table>");
        return contentString.toString();
    }
}
