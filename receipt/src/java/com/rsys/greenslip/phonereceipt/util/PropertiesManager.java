/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author rattank
 */
public class PropertiesManager {

    private static ResourceBundle properties = null ;
    private static PropertiesManager INSTANCE = null ;
    private static final String PROPERTIES_FILE_NAME = "pdfgenerator";

    private PropertiesManager(){
        properties = PropertyResourceBundle.getBundle(PROPERTIES_FILE_NAME);
    }

    public static PropertiesManager getInstance(){
        if(INSTANCE == null){
            synchronized(PropertiesManager.class) {
                if(INSTANCE == null){
                    INSTANCE = new PropertiesManager();
                }
            }
        }
        return INSTANCE;
    }

    public String getPropertyValue(final String propertyKey){
        String propertyValue = "";
        if(propertyKey != null){
            propertyValue = properties.getString(propertyKey);
        }
        return propertyValue; 
    }
}
