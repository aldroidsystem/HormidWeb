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
public abstract class BaseController<B> implements BaseControllerI<B>{
    
    protected BaseDaoI<B> dao=null;
    
    public BaseController() {}

    @Override
    public void insert(B bean) throws Exception {
        dao.insert(bean);
    }

    @Override
    public void updateById(B bean) throws Exception {
        dao.updateByPublicId(bean);
    }

    @Override
    public SelectResultBean<B> selectPage(SelectResultBean<B> selectBean) throws Exception {
        Integer count = dao.selectCountAll();
        
        selectBean.countPage(count);
        
        if(selectBean.getPageCount()>0){
            List<B> data = dao.selectPage(selectBean.getLimit(), 
                    selectBean.getOffset());
            selectBean.setData(data);
        }
        return selectBean;
    }

    @Override
    public B selectLastByPublicId(int id) throws Exception {
        return dao.selectLastByPublicId(id);
    }
    
    @Override
    public B selectById(int id) throws Exception {
        return dao.selectById(id);
    }
    
    @Override
    public B selectByPublicId(int id) throws Exception {
        return dao.selectByPublicId(id);
    }

    @Override
    public void deleteById(int id, int userId) throws Exception {
        dao.deleteByPublicId(id, userId);
    }
    
    @Override
    public List<B> selectAll() throws Exception{
        return dao.selectAll();
    }
}
