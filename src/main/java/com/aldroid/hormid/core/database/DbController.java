/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldroid.hormid.core.database;

import java.util.List;

/**
 *
 * @author renaldo
 * @param <B>
 */
public abstract class DbController<B> implements DbControllerI<B>{
    
    protected DbDaoI<B> dao=null;
    
    public DbController() {}


    @Override
    public void delete(B bean) throws Exception {
        dao.delete(bean);
    }
    
    @Override
    public void insert(B bean) throws Exception {
        dao.insert(bean);
    }

    @Override
    public void update(B bean) throws Exception {
        dao.update(bean);
    }

    @Override
    public SelectResultBean<B> selectPagination(SelectResultBean<B> selectBean) throws Exception {
        return dao.selectPagination(selectBean);
    }

    @Override
    public List<B> select(B bean) throws Exception {
        return dao.select(bean);
    }
    
    @Override
    public B selectSingle(B bean) throws Exception {
        return dao.selectSingle(bean);
    }
    
}
