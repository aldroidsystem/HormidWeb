/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.generic.process;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aldroid.hormid.model.generic.Properties;
import com.aldroid.hormid.model.generic.Role;
import com.aldroid.hormid.model.generic.User;
import com.aldroid.hormid.model.transaksi.Harga;
import com.aldroid.hormid.service.generic.PropertiesService;
import com.aldroid.hormid.service.generic.UserService;
import com.aldroid.hormid.service.transaksi.HargaService;

/**
 *
 * @author renaldo
 */
@Component
public class GlobalSessionObject {

    private static final Logger logger = Logger.getLogger(GlobalSessionObject.class);
    
    private List<Properties> properties;
    private List<Role> role;
    private Map<String,String> roleMap;
    private Harga hargaSekarang;
    private Date pengecekanTerakhir = new Date();
    private Map<String,String> listPetani;
    private Map<String,String> listSupir;
    
    @Autowired
    PropertiesService propertiesService;

    @Autowired
    UserService userService;

    @Autowired
    HargaService hargaService;
    
    public GlobalSessionObject() {
    }
    
    @PostConstruct
    void iniVariables() throws Exception {
		logger.info(this.getClass()+":Load all properties");
        properties = propertiesService.selectAllProperties();
    }
    
    public void updatePropertiesByCode(Properties newBean) throws Exception{
    	Properties bean = getPropertiesByCode(newBean.getCode());
    	updateProperties(bean, newBean);
    }
    
    public void updateProperties(Properties bean, Properties newBean) throws Exception{
    	bean.setValue(newBean.getValue());
    	propertiesService.setValueDataType(bean);
    }

    public void insertProperties(Properties newBean) throws Exception{
    	this.properties.add(newBean);
    }
    
    public Properties getPropertiesByCode(String code) throws Exception{
        if (properties !=null && !properties.isEmpty()){
            Iterator<Properties> iterator = properties.iterator();
            while(iterator.hasNext()){
            	Properties propertyTemp = iterator.next();
                if(propertyTemp.getCode().equals(code)){
                   return propertyTemp;
                }
            }
        }
        return null;
    }
    
    public List<Properties> getProperties() {
        return properties;
    }
    
    public List<Properties> searchPropertiesNameDetails(String text){
    	List<Properties> result = new ArrayList<>();
    	if (text == null || text.equals("")){
    		return getProperties();
    	}
    	
    	for (Properties property : this.properties){
    		if (property.getPropertyDesc() != null && property.getPropertyDesc().toLowerCase().indexOf(text.toLowerCase()) >=0){
    			result.add(property);
    			continue;
    		}
    	}
    	
    	return result;
    }

	public List<Role> getRole() {
		
		if(this.role == null || role.isEmpty()){
			this.role = userService.selectAllRole();
		}
		return role;
	}

	public Map<String, String> getRoleMap() {
		if (roleMap == null){
			roleMap = new HashMap<>();
			List<Role> roles = getRole();
			for(Role role : roles){
				roleMap.put(role.getCode(), role.getName());
			}
		}
		return roleMap;
	}

	public Harga getHargaSekarang() throws Exception {
		if(hargaSekarang == null){
			hargaSekarang = hargaService.getHargaSekarang();
		} else {
			if (pengecekanTerakhir.compareTo(new Date())!=0){
				hargaSekarang = hargaService.getHargaSekarang();
			}
		}
		return hargaSekarang;
	}



	public void resetHargaSekarang() {
		hargaSekarang = null;
	}

	public Map<String, String> getListPetani() throws Exception {
		if (listPetani == null || listPetani.isEmpty()){
			List<User> listUser = userService.selectListPetani();
			listPetani = new HashMap<>();
			if (listUser != null){
				for (User u : listUser){
					listPetani.put(u.getUsername(), u.getFullname());
				}
			}
		}
		return listPetani;
	}

	public void resetListPetani() {
		this.listPetani = null;
	}

	public Map<String, String> getListSupir() throws Exception {
		if (listSupir == null || listSupir.isEmpty()){
			List<User> listUser = userService.selectListSupir();
			listSupir = new HashMap<>();
			if (listUser != null){
				for (User u : listUser){
					listSupir.put(u.getUsername(), u.getFullname());
				}
			}
		}
		return listSupir;
	}

	public void resetListSupir() {
		this.listSupir = null;
	}
}
