/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.lapak.dao;

import com.aldroid.hormid.lapak.bean.HargaBean;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 *
 * @author renaldo
 */
@Repository
public interface HargaDao{

    final static String INSERT = "call pr_harga_insert"
    		+ "(#{createdBy}"
    		+ ",#{createdDate}"
    		+ ",#{hargaJual}"
    		+ ",#{hargaBeli})";
    
    @Delete(INSERT)
    abstract void insert(HargaBean bean) throws Exception;
    
    
}