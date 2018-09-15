/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.bo;

import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAO;
import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAOImpl;
import com.rsys.greenslip.phonereceipt.dto.ReceiptDTO;
import com.rsys.greenslip.phonereceipt.util.Constants;
import com.rsys.greenslip.phonereceipt.util.PDFGenerator;
import com.rsys.greenslip.phonereceipt.util.SimplePDFGenerator;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.paramValueType;
import java.io.ByteArrayInputStream;
import java.util.Date;
//import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Past;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import org.primefaces.event.CaptureEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author krattan
 */
@ManagedBean
@SessionScoped
public class PhoneReceiptBean {

    private int receiptId;
    private String storeName;
    private String phoneModel;
    private String phoneMake;
    private String phoneCondition;
    private double amount;
    private String sellerName;
    private String sellerContactNumber;
    private String sellerEmailId;
    private String sellerPhotoIdType;
    private String photoIdLocation;
    private String photoIdImageName;
    private String storeManager;
    private String sellerSignature;
    @Past
    private Date tradeDate = new Date();
    private boolean imageCaptured;
    private String imageExternalPath;
    private StreamedContent streamedContent;
    private String pdfFilePath;
    private String logoLocation;
    private String signature;
    private String signatureExternalPath;
    private String signatureInternalPath;
    private String photoIdInternalPath;

    public String getSignatureInternalPath() {
        return signatureInternalPath;
    }

    public void setSignatureInternalPath(String signatureInternalPath) {
        this.signatureInternalPath = signatureInternalPath;
    }

    public String getPhotoIdInternalPath() {
        return photoIdInternalPath;
    }

    public void setPhotoIdInternalPath(String photoIdInternalPath) {
        this.photoIdInternalPath = photoIdInternalPath;
    }

    public String getSignatureExternalPath() {
        return signatureExternalPath;
    }

    public void setSignatureExternalPath(String signatureExternalPath) {
        this.signatureExternalPath = signatureExternalPath;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLogoLocation() {
        logoLocation = Constants.BASE_IMAGE_LOCATION + "logo.png";
        return logoLocation;
    }

    public void setLogoLocation(String logoLocation) {
        this.logoLocation = logoLocation;
    }

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public String getImageExternalPath() {
        return imageExternalPath;
    }

    public void setImageExternalPath(String imageExternalPath) {
        this.imageExternalPath = imageExternalPath;
    }

    public boolean isImageCaptured() {
        return imageCaptured;
    }

    public void setImageCaptured(boolean imageCaptured) {
        this.imageCaptured = imageCaptured;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getPhoneMake() {
        return phoneMake;
    }

    public void setPhoneMake(String phoneMake) {
        this.phoneMake = phoneMake;
    }

    public String getPhoneCondition() {
        return phoneCondition;
    }

    public void setPhoneCondition(String phoneCondition) {
        this.phoneCondition = phoneCondition;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerContactNumber() {
        return sellerContactNumber;
    }

    public void setSellerContactNumber(String sellerContactNumber) {
        this.sellerContactNumber = sellerContactNumber;
    }

    public String getSellerEmailId() {
        return sellerEmailId;
    }

    public void setSellerEmailId(String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }

    public String getSellerPhotoIdType() {
        return sellerPhotoIdType;
    }

    public void setSellerPhotoIdType(String sellerPhotoIdType) {
        this.sellerPhotoIdType = sellerPhotoIdType;
    }

    public String getPhotoIdLocation() {
        return photoIdLocation;
    }

    public void setPhotoIdLocation(String photoIdLocation) {
        this.photoIdLocation = photoIdLocation;
    }

    public String getStoreManager() {
        return storeManager;
    }

    public void setStoreManager(String storeManager) {
        this.storeManager = storeManager;
    }

    public String getSellerSignature() {
        return sellerSignature;
    }

    public void setSellerSignature(String sellerSignature) {
        this.sellerSignature = sellerSignature;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    /**
     * Creates a new instance of PhoneReceiptBean
     */
    public PhoneReceiptBean() {
    }

    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);

        return String.valueOf(i);
    }

    public String getPhotoIdImageName() {
        return photoIdImageName;
    }

    public void setPhotoIdImageName(String photoIdImageName) {
        this.photoIdImageName = photoIdImageName;
    }

    public void oncapture(CaptureEvent captureEvent) {
        photoIdImageName = getRandomImageName();
        byte[] data = captureEvent.getData();

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        photoIdLocation = "D:"+ File.separator + "greenslip"  + File.separator + "images" + File.separator + "photoid" + File.separator + photoIdImageName + ".jpeg";
        photoIdLocation = externalContext.getRealPath("") + File.separator + "images" + File.separator + "photoid" + File.separator + photoIdImageName + ".jpeg";
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(photoIdLocation));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch (IOException e) {
            throw new FacesException("Error in writing captured image.Trying to copy image to [" + photoIdLocation + "]", e);
        }
        imageCaptured = true;
        imageExternalPath = Constants.BASE_IMAGE_LOCATION + "photoid/" + photoIdImageName + ".jpeg";
        photoIdInternalPath = photoIdLocation; 
    }

    public String confirmSubmission() {
//        Generate PDF from submitted data
        PDFGenerator pdfGenerator = new SimplePDFGenerator();
        pdfFilePath = pdfGenerator.generatePDF(this);
        this.streamedContent = getPDFData(pdfFilePath);
//        make database entry 
        ReceiptDTO receiptDTO = getReceiptDTO(); 
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl(); 
        int receiptId = phoneReceiptDAO.saveReceipt(receiptDTO);
        System.out.println("Make Database entry !!!!!");
//        Reset Bean
//        resetBean();
        setReceiptId(receiptId);
        
        return "printPdf";
    }

    private void resetBean() {
        storeName = "";
        phoneModel = "";
        phoneMake = "";
        phoneCondition = "";
        amount = 0;
        sellerName = "";
        sellerContactNumber = "";
        sellerEmailId = "";
        sellerPhotoIdType = "";
        photoIdLocation = "";
        photoIdImageName = "";
        storeManager = "";
        sellerSignature = "";
        tradeDate = new Date();
//        streamedContent = null ; 
        imageExternalPath = "";
        imageCaptured = false;
        sellerSignature = null;
    }

    private StreamedContent getPDFData(String pdfFile) {
        InputStream in = null;
        try {
            System.out.println("Rendering contents from file " + pdfFile + " ....");
            File initialFile = new File(pdfFile);
            in = new FileInputStream(initialFile);
            streamedContent = null;
//        InputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
            streamedContent = new DefaultStreamedContent(in, "application/pdf");
            //-------
/*            
             Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
             byte[] b = (byte[]) session.get("reportBytes");
             if (b != null) {
             streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(b), "application/pdf");
             }
             */
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        /*       finally {
         try {
         if (in != null) {
         in.close();
         }
         } catch (IOException ex) {
         ex.printStackTrace();
         }
         }
         */
        return streamedContent;
    }
    private boolean signatureCaptured = false;

    public boolean isSignatureCaptured() {
        return signatureCaptured;
    }

    public void setSignatureCaptured(boolean signatureCaptured) {
        this.signatureCaptured = signatureCaptured;
    }

    public void captureSignature() {
        try {
            int i = (int) (Math.random() * 10000000);
            String signatureFileName = String.valueOf(i) + ".png";
            String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String signatureFileLocation = getSignatureLocation(folderName) + File.separator + signatureFileName;
            System.out.println("Writing Signature to file [" + signatureFileLocation + "]");
            String encoded = signature.substring(Constants.URL_DATA_PNG_BASE64_PREFIX.length());
            byte[] decoded = Base64.getDecoder().decode(encoded);
            Path path = Paths.get(signatureFileLocation);
            Files.write(path, decoded);
            signature = null;
            signatureCaptured = true;
            signatureExternalPath = Constants.BASE_IMAGE_LOCATION + "signature" + "/" + folderName + "/" + signatureFileName;
            signatureInternalPath = signatureFileLocation ; 
            System.out.println("File Created sucessfully at ["+signatureInternalPath+"]");
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

    private ReceiptDTO getReceiptDTO() {
        ReceiptDTO receiptDTO = new ReceiptDTO(); 
        receiptDTO.setAmount(this.getAmount());
        receiptDTO.setPdfFilePath(pdfFilePath);
        receiptDTO.setPhoneCondition(phoneCondition);
        receiptDTO.setPhoneMake(phoneMake);
        receiptDTO.setPhoneModel(phoneModel);
        receiptDTO.setPhotoIdLocation(photoIdLocation);
        receiptDTO.setReceiptId(receiptId);
        receiptDTO.setSellerContactNumber(sellerContactNumber);
        receiptDTO.setSellerEmailId(sellerEmailId);
        receiptDTO.setSellerName(sellerName);
        receiptDTO.setSellerPhotoIdType(sellerPhotoIdType);
        receiptDTO.setSellerSignature(signature);
        receiptDTO.setStoreManager(storeManager);
        receiptDTO.setStoreName(storeName);
        receiptDTO.setTradeDate(tradeDate);
        return receiptDTO; 
    }

}
