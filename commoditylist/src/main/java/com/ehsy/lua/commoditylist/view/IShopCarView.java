package com.ehsy.lua.commoditylist.view;

import com.ehsy.lua.commoditylist.model.Product;

import java.util.List;

/**
 * Created by Lua on 2015/12/25 14:41.
 */
public interface IShopCarView {
    void onDataLoaded(List<Product> products);



    void notifyDataSetChanged();

    void onTotalSelect(String totalSelect);

    void selectAllOnSelect();

    void selectAllOnUnSelect();

    void onTotalPrice(String totalPrice);

    void gotoPay();
}
