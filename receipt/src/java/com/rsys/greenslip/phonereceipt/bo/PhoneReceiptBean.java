/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.bo;

import com.rsys.greenslip.phonereceipt.util.Constants;
import java.util.Date;
//import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Past;
import java.io.File;
import java.io.IOException;
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
public class PhoneReceiptBean {

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
    private Date tradeDate;
    private boolean imageCaptured; 
    private String imageExternalPath;

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
        imageCaptured=true; 
        imageExternalPath=Constants.BASE_IMAGE_LOCATION + photoIdImageName + ".jpeg" ; 
    }

    public void confirmSubmission(){
//        make database entry
//        Generate PDF from submitted data
        
//        Reset Bean
        resetBean();
    }
    
    
    private void resetBean(){
    storeName = "" ;
    phoneModel = "" ;
    phoneMake = "" ;
    phoneCondition = "";
    amount = 0 ;
    sellerName = "" ;
    sellerContactNumber = "";
    sellerEmailId = "";
    sellerPhotoIdType = "";
    photoIdLocation = "";
    photoIdImageName = ""; 
    storeManager = "" ;
    sellerSignature = "";
    tradeDate = new Date() ;
    }
}
