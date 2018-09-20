/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsys.greenslip.phonereceipt.servlet;

import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAO;
import com.rsys.greenslip.phonereceipt.dao.PhoneReceiptDAOImpl;
import com.rsys.greenslip.phonereceipt.dto.DropdownResourceDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rsys.greenslip.phonereceipt.util.Constants;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author krattan
 */
public class DropdownResourceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String responseValue = null;
        String action = request.getParameter(Constants.PARAMETER_ACTION);
        String resource = request.getParameter(Constants.PARAMETER_RESOURCE);

        if (action != null && action.equalsIgnoreCase(Constants.RESOURCE_ACTION_ADD)) {
            String resourceValue = request.getParameter(Constants.PARAMETER_RESOURCE_VALUE);
            responseValue = addResource(resource, resourceValue);
        }

        if (action != null && action.equalsIgnoreCase(Constants.RESOURCE_ACTION_GET)) {
            String resourceQuery = request.getParameter(Constants.PARAMETER_RESOURCE_VALUE);
            responseValue = getResource(resource, resourceQuery);
        }

        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(responseValue);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String addResource(String resource, String resourceValue) {
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl();
        DropdownResourceDTO dropdownResourceDTO = new DropdownResourceDTO(); 
        dropdownResourceDTO.setValue(resourceValue);
        String result = phoneReceiptDAO.addDropdownResource(resource,resourceValue);
        return result;
    }

    private String getResource(String resource, String resourceQuery) {
        PhoneReceiptDAO phoneReceiptDAO = new PhoneReceiptDAOImpl();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder(); 
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        JsonObjectBuilder jsonResultObjectBuilder = Json.createObjectBuilder();
        List<DropdownResourceDTO> resultList = phoneReceiptDAO.getDropdownResource(resource, resourceQuery);
        Iterator<DropdownResourceDTO> iterator = resultList.iterator();
        int count = 0 ; 
        while (iterator.hasNext()) {
            DropdownResourceDTO dropdownResourceDTO = iterator.next();
            jsonObjectBuilder.add(Constants.JSON_KEY_ID , dropdownResourceDTO.getId()); 
            jsonObjectBuilder.add(Constants.JSON_KEY_VALUE , dropdownResourceDTO.getValue()); 
            jsonArrayBuilder.add(jsonObjectBuilder); 
            count++; 
        }
        JsonArray jsonArray = jsonArrayBuilder.build(); 
        jsonResultObjectBuilder.add("total_results", count); 
        jsonResultObjectBuilder.add("results", jsonArray); 
        JsonObject resultObject = jsonResultObjectBuilder.build(); 
        return resultObject.toString(); 
    }

}
