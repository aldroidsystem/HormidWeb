/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.controller;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.common.bean.TransactionTypeEnum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.aldroid.hormid.transaksi.bean.TimbangJembatanBean;
import com.aldroid.hormid.transaksi.dao.TimbangJembatanDao;

/**
 *
 * @author renaldo
 */
@Service
public class TimbangJembatanController {
    @Autowired
    TimbangJembatanDao dao;
    
    @Autowired
    SessionBean sessionBean;
    
    
    public String generateNoSlipTimbang() throws Exception{
        StringBuilder str = new StringBuilder(TransactionTypeEnum.TIMBANG_JEMBATAN.getValue());
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
    
    
    public void insertTimbangPertama(TimbangJembatanBean bean) throws Exception{
        dao.insertTimbangMasuk(bean);
    }
    
    public void insertTimbangKedua(TimbangJembatanBean bean) throws Exception{
        dao.insertTimbangJembatan(bean);
        dao.deleteTimbangJembatanMasukByNoSlip(bean.getNoSlip());
    }
    
    public List<TimbangJembatanBean> selectTimbangPertamaAll() throws Exception{
        return dao.selectTimbangMasukAll();
    }
    
    public TimbangJembatanBean selectTimbangKeduaByNoSlip(String noSlip) throws Exception{
        return dao.selectTimbangJembatanByNoSlip(noSlip);
    }
    
    public TimbangJembatanBean selectTimbangPertamaByNoSlip(String noSlip) throws Exception{
        return dao.selectTimbangJembatanMasukByNoSlip(noSlip);
    }
    
    public void deleteTimbangPertamaByNoSlip(String noSlip) throws Exception{
        dao.deleteTimbangJembatanMasukByNoSlip(noSlip);
    }
    
    public List<TimbangJembatanBean> selectTimbangKeduaAllFiltered(
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
        return dao.selectTimbangJembatanAllFiltered(
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
    
   public void deleteTimbangKedua(String noSlip, Integer deletedBy,String alasanDelete) throws Exception{
        dao.deleteTimbangJembatan(noSlip, deletedBy, alasanDelete);
    }
}
