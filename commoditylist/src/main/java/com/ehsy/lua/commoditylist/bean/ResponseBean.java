package com.ehsy.lua.commoditylist.bean;

import com.ehsy.lua.commoditylist.model.Product;

import java.util.List;

/**
 * Created by Lua on 2015/12/24 11:10.
 */
public class ResponseBean {
    String hrefurl;
    String defaultorder;
    List<Product> search;
    Pages pages;
    List<String> item;


    public String getHrefurl() {
        return hrefurl;
    }

    public void setHrefurl(String hrefurl) {
        this.hrefurl = hrefurl;
    }

    public String getDefaultorder() {
        return defaultorder;
    }

    public void setDefaultorder(String defaultorder) {
        this.defaultorder = defaultorder;
    }

    public List<Product> getSearch() {
        return search;
    }

    public void setSearch(List<Product> search) {
        this.search = search;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }
}
