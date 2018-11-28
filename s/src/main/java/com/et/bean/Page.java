package com.et.bean;

import java.util.List;

import lombok.Data;

@Data
public class Page<T> {
    private int pageNumber; 
    
    private int pageSize;
    
    private int total;
    
    private int pageCount;
    
    private int pre;
    
    private int next;
    
    private int start;
    
    private List<T> data;
    
    public int getPageCount() {
        return (total+pageSize-1)/pageSize;
    }
    
    public int getPre() {
        if(pageNumber>1) {
            return pageNumber-1;
        }
        return 1;
    }
    
    public int getNext() {
        if(pageNumber<pageCount) {
            return pageNumber+1;
        }
        return getPageCount();
    }
    
    public int getStart() {
        return (pageNumber-1)*pageSize;
    }

}
