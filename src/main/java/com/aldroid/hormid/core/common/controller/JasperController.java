/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.controller;

import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrintManager;

/**
 *
 * @author renaldo
 */
public class JasperController {   
    
    public static void print(String sourceFileName,Map parameters){
      String printFileName = null;
      try {
    	     printFileName = JasperFillManager.fillReportToFile(
            sourceFileName, parameters, new JREmptyDataSource());
         if(printFileName != null){
             JasperPrintManager.printReport( printFileName, true);
         }
      } catch (JRException e) {
         e.printStackTrace();
      }
    }
    
    public static void exportPDF(String sourceFileName,Map parameters, String path){
      String printFileName = null;
      try {
    	     printFileName = JasperFillManager.fillReportToFile(
            sourceFileName, parameters, new JREmptyDataSource());
             
         if(printFileName != null){
             JasperExportManager.exportReportToPdfFile(printFileName,
               path);
         }
      } catch (JRException e) {
         e.printStackTrace();
      }
    }
}
