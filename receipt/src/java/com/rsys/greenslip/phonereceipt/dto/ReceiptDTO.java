/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.dto;

import com.rsys.greenslip.phonereceipt.util.Constants;
import com.rsys.greenslip.phonereceipt.util.PropertiesManager;
import java.util.Date;
import javax.validation.constraints.Past;

/**
 *
 * @author krattan
 */
public class ReceiptDTO {
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
    private String photoIdBackLocation;
    private String photoIdBackImageName;
    private String storeManager;
    private String sellerSignature;
    @Past
    private Date tradeDate = new Date();
    private boolean imageCaptured;
    private String imageExternalPath;
    private String backImageExternalPath;
    private String pdfFilePath;
    private String logoLocation ; 
    private String signature;
    private String signatureExternalPath;
    private String signatureInternalPath;
    private String imeiNumber;
    private boolean signatureCaptured = false;
    private boolean backImageCaptured = false;
    private String captureBackImage = "2" ;

    public String getCaptureBackImage() {
        return captureBackImage;
    }

    public void setCaptureBackImage(String captureBackImage) {
        this.captureBackImage = captureBackImage;
    }
    

    public boolean isBackImageCaptured() {
        return backImageCaptured;
    }

    public void setBackImageCaptured(boolean backImageCaptured) {
        this.backImageCaptured = backImageCaptured;
    }
    
    public boolean isImageCaptured() {
        return imageCaptured;
    }

    public void setImageCaptured(boolean imageCaptured) {
        this.imageCaptured = imageCaptured;
    }

    public String getImageExternalPath() {
        return imageExternalPath;
    }

    public void setImageExternalPath(String imageExternalPath) {
        this.imageExternalPath = imageExternalPath;
    }
    public String getBackImageExternalPath() {
        return backImageExternalPath;
    }

    public void setBackImageExternalPath(String imageExternalPath) {
        this.backImageExternalPath = imageExternalPath;
    }

    public String getLogoLocation() {
        logoLocation = PropertiesManager.getInstance().getPropertyValue(Constants.PROPERTY_HEADER_LOGO_FILE) ; 
        return logoLocation;
    }

    public void setLogoLocation(String logoLocation) {
        this.logoLocation = logoLocation;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignatureExternalPath() {
        return signatureExternalPath;
    }

    public void setSignatureExternalPath(String signatureExternalPath) {
        this.signatureExternalPath = signatureExternalPath;
    }

    public String getSignatureInternalPath() {
        return signatureInternalPath;
    }

    public void setSignatureInternalPath(String signatureInternalPath) {
        this.signatureInternalPath = signatureInternalPath;
    }

    public boolean isSignatureCaptured() {
        return signatureCaptured;
    }

    public void setSignatureCaptured(boolean signatureCaptured) {
        this.signatureCaptured = signatureCaptured;
    }
    
    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
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

    public String getPhotoIdImageName() {
        return photoIdImageName;
    }

    public void setPhotoIdImageName(String photoIdImageName) {
        this.photoIdImageName = photoIdImageName;
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

    public String getPdfFilePath() {
        return pdfFilePath;
    }

    public void setPdfFilePath(String pdfFilePath) {
        this.pdfFilePath = pdfFilePath;
    }

    public String getPhotoIdBackLocation() {
        return photoIdBackLocation;
    }

    public void setPhotoIdBackLocation(String photoIdBackLocation) {
        this.photoIdBackLocation = photoIdBackLocation;
    }

    public String getPhotoIdBackImageName() {
        return photoIdBackImageName;
    }

    public void setPhotoIdBackImageName(String photoIdBackImageName) {
        this.photoIdBackImageName = photoIdBackImageName;
    }
    
    
/*
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
 */   
}
