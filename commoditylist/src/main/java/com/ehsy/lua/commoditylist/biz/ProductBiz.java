package com.ehsy.lua.commoditylist.biz;

import com.ehsy.lua.commoditylist.application.App;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.utils.VolleyUtils;

import java.util.Map;

/**
 * Created by Lua on 2015/12/30 9:20.
 */
public class ProductBiz {

    public void loadData(String keyWord,HttpListener listener) {

        HttpParameters parameters = new HttpParameters();
        parameters.addParameter("module", "search/result");
        parameters.addParameter("keywords", keyWord);
        parameters.addParameter("page", "10");
        parameters.addParameter("sort", "price");
        parameters.addParameter("order", "asc");

        VolleyUtils.request(parameters, listener);
    }

    public void reduce(Product product) {
        Map<Product, Integer> buyCar = App.getBuyCar();
        Integer newCount = buyCar.get(product) - 1;
        if (newCount <= 0) {
            newCount = 0;
        }
        buyCar.put(product, newCount);

    }

    public void add(Product product) {
        Map<Product, Integer> shopCar = App.getBuyCar();
        Integer newCount = shopCar.get(product) + 1;
        shopCar.put(product, newCount);
    }

    public void delete(Product product) {
        Map<Product, Integer> shopCar = App.getBuyCar();
        shopCar.remove(product);
    }
}
