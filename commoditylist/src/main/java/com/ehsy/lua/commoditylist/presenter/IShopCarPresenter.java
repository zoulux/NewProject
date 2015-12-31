package com.ehsy.lua.commoditylist.presenter;

import com.ehsy.lua.commoditylist.model.Product;

import java.util.List;

/**
 * Created by Lua on 2015/12/25 14:40.
 */
public interface IShopCarPresenter {
    void selectAll(List<Product> products);
    void cleanAll(List<Product> products);

    void loadData();

    void reduce(Product product);

    void add(Product product);

    void checkBoxOnChanged(Product product, boolean isChecked);


    void selectAllChanged(boolean isChecked);

    void delete(Product product);

    void gotoPay();
}
