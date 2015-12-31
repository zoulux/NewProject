package com.ehsy.lua.commoditylist.presenter;

import com.ehsy.lua.commoditylist.model.Product;

/**
 * Created by Lua on 2015/12/24 14:59.
 */
public interface IFindPresenter {
    void loadData(String keyWord);

    void pay();

    void add(Product product);
}
