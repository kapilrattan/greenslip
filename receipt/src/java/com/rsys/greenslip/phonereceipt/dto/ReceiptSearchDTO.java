/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author krattan
 */
public class ReceiptSearchDTO {

    private String sellerName;
    private Date tradeDateFrom;
    private Date tradeDateTo;
    private String imeiNumber;
    private String sellerContactNumber;
    private List<ReceiptDTO> searchResultList;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Date getTradeDateFrom() {
        return tradeDateFrom;
    }

    public void setTradeDateFrom(Date tradeDateFrom) {
        this.tradeDateFrom = tradeDateFrom;
    }

    public Date getTradeDateTo() {
        return tradeDateTo;
    }

    public void setTradeDateTo(Date tradeDateTo) {
        this.tradeDateTo = tradeDateTo;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public String getSellerContactNumber() {
        return sellerContactNumber;
    }

    public void setSellerContactNumber(String sellerContactNumber) {
        this.sellerContactNumber = sellerContactNumber;
    }

    public List<ReceiptDTO> getSearchResultList() {
        return searchResultList;
    }

    public void setSearchResultList(List<ReceiptDTO> searchResultList) {
        this.searchResultList = searchResultList;
    }
}
