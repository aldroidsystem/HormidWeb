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
public interface DbControllerI<B> {
    abstract void insert(B bean) throws Exception;
    abstract void update(B bean) throws Exception;
    abstract void delete(B bean) throws Exception;
    abstract List<B> select(B bean) throws Exception;
    abstract SelectResultBean<B> selectPagination(SelectResultBean<B> selectBean) throws Exception;
    abstract B selectSingle(B bean) throws Exception;
}
