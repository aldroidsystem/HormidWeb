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
public class SelectResultBean<B> {
    private Integer limit;
    private List<B> data=null;
    private Integer currentPage;
    private Integer pageCount;

    public SelectResultBean() {
        limit = 10;
        currentPage=1;
        pageCount=-1;
    }

    public List<B> getData() {
        return data;
    }

    public void setData(List<B> data) {
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    
    public void nextPage() {
        this.currentPage++;
    }

    public void previousPage() {
        this.currentPage--;
    }
    
    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return (getCurrentPage() - 1) * getLimit();
    }
    
    public void countPage(Integer count){
        if(count != null && count>0){
            Integer totalPage = (int) Math.ceil(count.doubleValue()/getLimit().doubleValue());
            setPageCount(totalPage);
        }
    }
}
