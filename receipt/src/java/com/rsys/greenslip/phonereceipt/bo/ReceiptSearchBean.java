/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.bo;

import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAO;
import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAOImpl;
import com.rsys.greenslip.phonereceipt.dto.ReceiptDTO;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author krattan
 */
@ManagedBean
@RequestScoped
public class ReceiptSearchBean {

    private String sellerName;
    private Date tradeDateFrom;
    private Date tradeDateTo;
    private String imeiNumber;
    private String sellerContactNumber;
    private List<ReceiptDTO> searchResultList ; 
    private ReceiptDTO selectedReceipt; 

    public ReceiptDTO getSelectedReceipt() {
        return selectedReceipt;
    }

    public void setSelectedReceipt(ReceiptDTO selectedReceipt) {
        this.selectedReceipt = selectedReceipt;
    }
    

    public List<ReceiptDTO> getSearchResultList() {
        return searchResultList;
    }

    public void setSearchResultList(List<ReceiptDTO> searchResultList) {
        this.searchResultList = searchResultList;
    }

    public String getSellerContactNumber() {
        return sellerContactNumber;
    }

    public void setSellerContactNumber(String sellerContactNumber) {
        this.sellerContactNumber = sellerContactNumber;
    }
    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

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

    public List<ReceiptDTO> searchReceipts() {
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl();
        return phoneReceiptDAO.getReceiptList();
    }

    /**
     * Creates a new instance of ReceiptSearchBean
     */
    public ReceiptSearchBean() {
    }

    public void viewReceipt(){
        
    }
}
