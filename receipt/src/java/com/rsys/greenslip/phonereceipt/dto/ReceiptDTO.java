/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.dto;

import java.util.Date;

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
    private String storeManager;
    private String sellerSignature;
    private Date tradeDate ; 
    private String pdfFilePath;
    private String imeiNumber = "";

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
    
}
