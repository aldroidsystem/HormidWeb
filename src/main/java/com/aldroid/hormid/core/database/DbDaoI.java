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
 * @param <E>
 */
public interface DbDaoI<E> {
    abstract void delete(E bean) throws Exception;
    
    abstract void insert(E bean) throws Exception;

    abstract void update(E bean) throws Exception;

    abstract List<E> select(E bean) throws Exception;
    
    abstract SelectResultBean<E> selectPagination(SelectResultBean<E> selectBean) throws Exception;
    
    abstract E selectSingle(E bean) throws Exception;
    
}
