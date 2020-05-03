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
public interface BaseDaoI<E> {
    abstract void deleteByPublicId(int publicId,int lastUpdatedBy) throws Exception;
    
    abstract void insert(E bean) throws Exception;
    
    abstract void updateByPublicId(E bean) throws Exception;
    
    abstract E selectById(int id) throws Exception;
    
    abstract E selectByPublicId( int publicid) throws Exception;
    
    abstract E selectLastByPublicId(int publicid) throws Exception;
    
    abstract List<E> selectPage(int limit,int offset) throws Exception;
    
    abstract Integer selectCountAll() throws Exception;
    
    abstract List<E> selectAll() throws Exception;
}
