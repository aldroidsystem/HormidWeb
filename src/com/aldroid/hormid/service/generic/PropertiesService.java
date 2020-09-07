/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.service.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldroid.hormid.generic.process.GlobalSessionObject;
import com.aldroid.hormid.mapper.generic.PropertiesMapper;
import com.aldroid.hormid.model.generic.Properties;


/**
 *
 * @author renaldo
 */
@Service
public class PropertiesService{

    @Autowired(required=true)
    PropertiesMapper propertiesMapper;

    @Autowired
	private GlobalSessionObject globalSessionObject;

    public List<Properties> selectAllProperties() throws Exception {
    	List<Properties> listProperties = propertiesMapper.selectAllProperties();
    	for(Properties properties : listProperties){
    		setValueDataType(properties);
    	}
        return listProperties;
    }
    
    public void setValueDataType(Properties properties) throws NumberFormatException{
    	if(properties.getTipeData().equals("Kata")){
			properties.setKata(properties.getValue());
		} else if (properties.getTipeData().equals("Daftar Kata")) {
			properties.setDaftarKata(Arrays.asList(properties.getValue().split(",")));
		} else if (properties.getTipeData().equals("Angka")) {
			properties.setAngka(Integer.parseInt(properties.getValue()));
		} else if (properties.getTipeData().equals("Daftar Angka")) {
			List<String> daftarKata = Arrays.asList(properties.getValue().split(","));
			List<Integer> daftarAngka = new ArrayList<Integer>();
			for(String kata : daftarKata){
				daftarAngka.add(Integer.parseInt(kata));
			}
			properties.setDaftarAngka(daftarAngka);
		} else if (properties.getTipeData().equals("Desimal")) {
			properties.setDesimal(Float.valueOf(properties.getValue()));
		} else if (properties.getTipeData().equals("Daftar Desimal")) {
			List<String> daftarKata = Arrays.asList(properties.getValue().split(","));
			List<Float> daftarDesimal = new ArrayList<Float>();
			for(String kata : daftarKata){
				daftarDesimal.add(Float.valueOf(kata));
			}
			properties.setDaftarDesimal(daftarDesimal);
		}
    }
    
    public void update(Properties properties, Properties updateProperties) throws Exception {
    	propertiesMapper.updateProperties(properties);
    	globalSessionObject.updateProperties(updateProperties, properties);
    }    
}