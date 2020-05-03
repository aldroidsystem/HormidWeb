/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.controller;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.common.bean.TransactionTypeEnum;
import com.aldroid.hormid.transaksi.bean.TimbangBiasaBean;
import com.aldroid.hormid.transaksi.dao.TimbangBiasaDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author renaldo
 */
@Service
public class TimbangBiasaController {
    @Autowired
    TimbangBiasaDao dao;
    
    @Autowired
    SessionBean sessionBean;
    
    
    public String generateNoSlipTimbang() throws Exception{
        StringBuilder str = new StringBuilder(TransactionTypeEnum.TIMBANG_BIASA.getValue());
        String userIdHex = Integer.toHexString(sessionBean.getUser().getId());
        str.append(userIdHex.length()==1?"00":
                userIdHex.length()==2?"0":"");
        str.append(userIdHex);
//        if(sessionBean.getUser().getEmployee() != null 
//                && sessionBean.getUser().getEmployee().getBranch()!=null){
//            String branchIdHex = Integer.toHexString(sessionBean.getUser().getEmployee().getBranch().getId());
//            str.append(branchIdHex.length()==1?"00":
//                    branchIdHex.length()==2?"0":"");
//            str.append(branchIdHex);
//        }
        
        str.append(Integer.toHexString(dao.selectNextNoSlip()));
        return str.toString();
    }
    
    
    public TimbangBiasaBean selectTimbangByNoSlip(String noSlip) throws Exception{
        return dao.selectTimbangByNoSlip(noSlip);
    }
    
    public void insertTimbang(TimbangBiasaBean bean) throws Exception{
        dao.insertTimbang(bean);
    }
    
    public List<TimbangBiasaBean> selectTimbangAllFiltered(
            Integer supplierId,
            Date timestampTimbangKedua1,
            Date timestampTimbangKedua2,
            Boolean flagCekDicairkan,
            Double minNetto,
            Double maxNetto,
            Double minTotalBayar,
            Double maxTotalBayar,
            int orderBy,
            boolean asc,
            boolean isDeleted
    ) throws Exception {
        return dao.selectTimbangAllFiltered(
                supplierId,
                timestampTimbangKedua1,
                timestampTimbangKedua2,
                flagCekDicairkan,
                minNetto,
                maxNetto,
                minTotalBayar,
                maxTotalBayar,
                orderBy,
                asc,
                isDeleted);
    }

    public void updateCekPaid(String noSlip, Integer dicairkanBy) throws Exception{
        dao.updateCekPaid(noSlip,dicairkanBy);
    }
    
   public void deleteTimbang(String noSlip, Integer deletedBy,String alasanDelete) throws Exception{
        dao.deleteTimbang(noSlip, deletedBy, alasanDelete);
    }
}
