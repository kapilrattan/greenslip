/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.bo;

import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAO;
import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAOImpl;
import com.rsys.greenslip.phonereceipt.dto.ReceiptDTO;
import com.rsys.greenslip.phonereceipt.dto.ReceiptSearchDTO;
import com.rsys.greenslip.phonereceipt.util.Constants;
import com.rsys.greenslip.phonereceipt.util.PDFGenerator;
import com.rsys.greenslip.phonereceipt.util.SimplePDFGenerator;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import org.primefaces.event.CaptureEvent;

/**
 *
 * @author krattan
 */
@ManagedBean
@SessionScoped
public class ReceiptManagerBean {
private ReceiptDTO receiptDTO = new ReceiptDTO(); 
private ReceiptDTO selectedReceiptDTO = new ReceiptDTO() ; 
private ReceiptSearchDTO receiptSearchDTO = new ReceiptSearchDTO(); 


    public ReceiptSearchDTO getReceiptSearchDTO() {
        return receiptSearchDTO;
    }

    public void setReceiptSearchDTO(ReceiptSearchDTO receiptSearchDTO) {
        this.receiptSearchDTO = receiptSearchDTO;
    }

    public ReceiptDTO getReceiptDTO() {
        return receiptDTO;
    }

    public void setReceiptDTO(ReceiptDTO receiptDTO) {
        this.receiptDTO = receiptDTO;
    }

    public ReceiptDTO getSelectedReceiptDTO() {
        return selectedReceiptDTO;
    }

    public void setSelectedReceiptDTO(ReceiptDTO selectedReceiptDTO) {
        this.selectedReceiptDTO = selectedReceiptDTO;
    }



    /**
     * Creates a new instance of PhoneReceiptBean
     */
    public ReceiptManagerBean() {
    }

    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);

        return String.valueOf(i);
    }


    public void oncapture(CaptureEvent captureEvent) {
        receiptDTO.setPhotoIdImageName(getRandomImageName());
        byte[] data = captureEvent.getData();

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        photoIdLocation = "D:"+ File.separator + "greenslip"  + File.separator + "images" + File.separator + "photoid" + File.separator + photoIdImageName + ".jpeg";
        String photoIdLocation = externalContext.getRealPath("") + File.separator + "images" + File.separator + "photoid" + File.separator + receiptDTO.getPhotoIdImageName() + ".jpeg";
        receiptDTO.setPhotoIdLocation(photoIdLocation);
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(photoIdLocation));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch (IOException e) {
            throw new FacesException("Error in writing captured image.Trying to copy image to [" + photoIdLocation + "]", e);
        }
        receiptDTO.setImageCaptured(true);
        String imageExternalPath = Constants.BASE_IMAGE_LOCATION + "photoid/" + receiptDTO.getPhotoIdImageName() + ".jpeg";
        receiptDTO.setImageExternalPath(imageExternalPath);
    }

    public String confirmSubmission() {
        PDFGenerator pdfGenerator = new SimplePDFGenerator();
        String pdfFilePath = pdfGenerator.generatePDF(receiptDTO);
        receiptDTO.setPdfFilePath(pdfFilePath);
        
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl(); 
        int receiptId = phoneReceiptDAO.saveReceipt(receiptDTO);
        System.out.println("Make Database entry !!!!!");
        receiptDTO.setReceiptId(receiptId);
        selectedReceiptDTO = receiptDTO; 
        receiptDTO = new ReceiptDTO(); 
        return "printPdf";
    }

    public void captureSignature() {
        try {
            int i = (int) (Math.random() * 10000000);
            String signatureFileName = String.valueOf(i) + ".png";
            String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String signatureFileLocation = getSignatureLocation(folderName) + File.separator + signatureFileName;
            System.out.println("Writing Signature to file [" + signatureFileLocation + "]");
            String encoded = receiptDTO.getSignature().substring(Constants.URL_DATA_PNG_BASE64_PREFIX.length());
            byte[] decoded = Base64.getDecoder().decode(encoded);
            Path path = Paths.get(signatureFileLocation);
            Files.write(path, decoded);
            receiptDTO.setSignature(null);
            receiptDTO.setSignatureCaptured(true);
            String signatureExternalPath = Constants.BASE_IMAGE_LOCATION + "signature" + "/" + folderName + "/" + signatureFileName;
            receiptDTO.setSignatureExternalPath(signatureExternalPath);
            receiptDTO.setSignatureInternalPath(signatureFileLocation) ; 
            System.out.println("File Created sucessfully at ["+signatureFileLocation+"]");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getSignatureLocation(String folderName) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String fileLocation = externalContext.getRealPath("") + File.separator + "images" + File.separator + "signature" + File.separator + folderName;
        File directory = new File(fileLocation);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println(fileLocation + " : Folder/Directory is created successfully");
            } else {
                System.out.println(fileLocation + ": Directory/Folder creation failed!!!");
            }
        }

        return fileLocation;
    }

    public void searchReceipts() {
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl();
        List<ReceiptDTO> searchResult = phoneReceiptDAO.getReceiptList();
        receiptSearchDTO.setSearchResultList(searchResult);
    }
}
