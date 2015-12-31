package com.ehsy.lua.commoditylist.view;

import com.ehsy.lua.commoditylist.model.Product;

import java.util.List;

/**
 * Created by Lua on 2015/12/24 15:04.
 */
public interface IFindView {
    void onSuccess(List<Product> models);
    void onFaild(String  faild);
}
