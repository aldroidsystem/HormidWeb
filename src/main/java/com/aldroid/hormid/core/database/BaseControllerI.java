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
public interface BaseControllerI<B> {
    abstract void insert(B bean) throws Exception;
    abstract void updateById(B bean) throws Exception;
    abstract SelectResultBean<B> selectPage(SelectResultBean<B> selectBean) throws Exception;
    abstract B selectByPublicId(int id) throws Exception;
    abstract void deleteById(int id, int userId) throws Exception;
    abstract B selectLastByPublicId(int id) throws Exception;
    abstract B selectById(int id) throws Exception;
    abstract List<B> selectAll() throws Exception;
}
