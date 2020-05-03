/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.common.controller;

import com.aldroid.hormid.transaksi.bean.TimbangJembatanBean;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hormid
 */
public class CreateNotaTransaksiHTML {
    
    
    public void setData(TimbangJembatanBean timbang)throws Exception{
        InputStream in = getClass().getResourceAsStream("/txt/nota.html");
        StringBuilder str = CommonController.getStringFromInputStream(in);
        Map<String,String> maps = new HashMap<>();
        maps.put("%%noSlip%%", timbang.getNoSlip());
        maps.put("%%tanggal%%", CommonController.parseStringYMDHM(new Date()));
//        maps.put("%%supplier%%", timbang.getSupplier().getBranchName());
        maps.put("%%angkutan%%", timbang.getVehicle().getPlateNumber());
        maps.put("%%supir%%", timbang.getDriver().getFullname());
//        maps.put("%%address%%", branch.getAddress());
//        maps.put("%%lastUpdatedBy%%", branch.getLastUpdatedUser()!=null ? branch.getLastUpdatedUser().getUsername():"");
//        maps.put("%%timestampStatus%%", CommonController.parseStringYMDHM(branch.getTimestampStatus()));
        
        
        CommonController.replaceString(str, maps);
    }
}
