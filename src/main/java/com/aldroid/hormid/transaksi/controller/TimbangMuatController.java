/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.transaksi.controller;

import com.aldroid.hormid.core.common.bean.SessionBean;
import com.aldroid.hormid.core.common.bean.TransactionTypeEnum;
import com.aldroid.hormid.transaksi.bean.TimbangMuatBean;
import com.aldroid.hormid.transaksi.bean.TimbangMuatKaryawanBean;
import com.aldroid.hormid.transaksi.bean.TimbangMuatSupplierBean;
import com.aldroid.hormid.transaksi.dao.TimbangMuatDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author renaldo
 */
@Service
public class TimbangMuatController {
    @Autowired
    TimbangMuatDao dao;
    
    @Autowired
    SessionBean sessionBean;
    
    public String generateNoTimbangMuat() throws Exception{
        StringBuilder str = new StringBuilder(TransactionTypeEnum.TIMBANG_MUAT.getValue());
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
    
    
    public TimbangMuatBean selectTimbangByNoSlip(String noSlip) throws Exception{
        return dao.selectTimbangByNoSlip(noSlip);
    }
    
    public void insertTimbang(TimbangMuatBean bean) throws Exception{
        dao.insertTimbangMuat(bean);
        TimbangMuatBean inserted = dao.selectTimbangByNoSlip(bean.getNoMuat());
        
        if(bean.getTimbangMuatKaryawan()!= null && !bean.getTimbangMuatKaryawan().isEmpty()){
            for(TimbangMuatKaryawanBean karBean : bean.getTimbangMuatKaryawan()){
                karBean.setTimbangMuatId(inserted.getId());
                dao.insertTimbangMuatKaryawan(karBean);
            }
        } else {
            throw new Exception("Daftar Karyawan tidak ditemukan");
        }
        if(bean.getTimbangMuatSupplier()!= null && !bean.getTimbangMuatSupplier().isEmpty()){
            for(TimbangMuatSupplierBean supBean : bean.getTimbangMuatSupplier()){
                supBean.setTimbangMuatId(inserted.getId());
                dao.insertTimbangMuatSupplier(supBean);
            }
        } else {
            throw new Exception("Daftar Suplier tidak ditemukan");
        }
    }
    
    public List<TimbangMuatBean> selectTimbangAllFiltered(
            Integer vehicleId,
            Integer userId,
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
                vehicleId,
                userId,
                timestampTimbangKedua1,
                timestampTimbangKedua2,
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
   
   public TimbangMuatSupplierBean selectTimbangMuatSupplierByNoSlip(String noSlip) throws Exception{
       return dao.selectTimbangMuatSupplierByNoSlip(noSlip);
   }
}
