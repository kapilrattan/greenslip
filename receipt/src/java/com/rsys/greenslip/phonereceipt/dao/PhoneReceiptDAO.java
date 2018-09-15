/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.dao;

import com.rsys.greenslip.phonereceipt.dto.ReceiptDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author krattan
 */
public interface PhoneReceiptDAO {
    public int saveReceipt(ReceiptDTO receiptDTO); 
    public List<ReceiptDTO> getReceiptList(); 
    public List<ReceiptDTO> getReceiptListByDate(Date fromDate , Date toDate); 
    public List<ReceiptDTO> getReceiptListByIMEI(String imei); 
    public List<ReceiptDTO> getReceiptListBySellerName(String sellerName); 
    public List<ReceiptDTO> getReceiptListBySellerContact(String sellerContact); 
}
