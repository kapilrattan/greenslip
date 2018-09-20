/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.dto;

/**
 *
 * @author krattan
 */
public class DropdownResourceDTO {
    private int id; 
    private String value; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String toString(){
        StringBuilder builder = new StringBuilder(); 
        builder.append("ID:"+id); 
        builder.append("Value:"+value); 
        return builder.toString(); 
    }
}
