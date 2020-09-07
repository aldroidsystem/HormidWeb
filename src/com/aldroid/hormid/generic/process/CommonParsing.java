/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.generic.process;

//import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renaldo
 */
public class CommonParsing {

    private final static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private final static SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    private final static SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private final static Pattern pattern=Pattern.compile("^[a-zA-Z0-9]$");
//    private final static Gson gson = new Gson();
    private static final DecimalFormat currencyFormatter = new DecimalFormat("###,###");
    private static final NumberFormat decimalNumber = NumberFormat.getNumberInstance();
    
//    public static String parseStringJson(Object obj){
//        return gson.toJson(obj);
//    }
    
    public static String parseStringYMDHM(Date date){
        return date != null ?sdf1.format(date) : "";
    }

    public static String parseStringDMYHM(Date date){
        return date != null ?sdf3.format(date) : "";
    }
    
    public static String parseStringDMY(Date date){
        return date != null ?sdf2.format(date) : "";
    }
    
//    public static Object parseObjectJson(String json, Class kelas){
//        return gson.fromJson(json, kelas);
//    }
    
    public static Date parseDate(String dateString) {

        return new Date();
    }

    public static String parseArrayToStringDao(Object[] obj) {
        String parsedObj = "";
        if (obj != null && obj.length > 0) {
            parsedObj += "{";
            for (int i = 0; i < obj.length; i++) {
                parsedObj += (i + 1 == obj.length) ? obj[i] : obj[i] + ",";
            }
            parsedObj += "}";
        }
        return parsedObj;
    }

    public static StringBuilder getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb;
    }
    
    public static void replaceString(StringBuilder content, Map<String,String> replace){
        Set<String> keyset = replace.keySet();
        Iterator<String> iterator = keyset.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            int idx = content.indexOf(key);
            content.replace(idx, idx+key.length(), replace.get(key)==null?"":replace.get(key));            
        }
    }
    
    public String generateCode(String name, int length){
        StringBuilder strbuileder = new StringBuilder("");
        for (int i = 0; i < length || i < name.length(); i++) {
            Matcher m=pattern.matcher(name.substring(i, i+1));
            if(m.matches())
                strbuileder.append(name.substring(i, i+1));
        }
        return strbuileder.toString();
    }
    
    public static String parseStringPrice (Double price) {
        return currencyFormatter.format(price!=null?Math.ceil(price):0);
    }
    
    public static Double parseDouble(String number){
        try {
            return decimalNumber.parse(number).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(CommonParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0d;
    }
    
    public static Date floor(Date date){
        if(date ==null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static Date ceil(Date date){
        if(date ==null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }
}
