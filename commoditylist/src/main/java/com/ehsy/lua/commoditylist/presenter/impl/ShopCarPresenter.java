package com.ehsy.lua.commoditylist.presenter.impl;

import android.util.Log;

import com.ehsy.lua.commoditylist.application.App;
import com.ehsy.lua.commoditylist.biz.ProductBiz;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IShopCarPresenter;
import com.ehsy.lua.commoditylist.view.IShopCarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lua on 2015/12/25 14:41.
 */
public class ShopCarPresenter implements IShopCarPresenter {
    private static final String TAG = "ShopCarPresenter";
    private IShopCarView shopCarView;
    private ProductBiz productBiz;

    private Map<Product, Integer> shopCar = App.getBuyCar();
    List<Product> products;

    public ShopCarPresenter(IShopCarView shopCarView,List<Product> products) {
        this.shopCarView = shopCarView;
        this.products=products;
        productBiz=new ProductBiz();

    }


    @Override
    public void selectAll(List<Product> products) {
        for (Product product : products) {
            product.setIsChecked(true);
        }

        shopCarView.notifyDataSetChanged();

    }

    @Override
    public void cleanAll(List<Product> products) {
        for (Product product : products) {
            product.setIsChecked(false);
        }
        shopCarView.notifyDataSetChanged();
    }




    @Override
    public void loadData() {
        //     Map<ProductModel, Integer> shopCar = App.getBuyCar();   //数据直接从内存获取，也可以从服务器或者从本地获取
        List<Product> products = new ArrayList<>();
        for (Product product : shopCar.keySet()) {
            product.setIsChecked(true);
            //逻辑部分,小计在此先计算
            clculateAndSetPartPrice(product);
            products.add(product);
            Log.d(TAG, "loadData :" + product.getTitle() + "数量--->" + shopCar.get(product));
        }
        shopCarView.onDataLoaded(products);


    }

    @Override
    public void reduce(Product product) {
        productBiz.reduce(product);

//        Map<Product, Integer> buyCar = App.getBuyCar();
//        Integer newCount = buyCar.get(product) - 1;
//        if (newCount <= 0) {
//            newCount = 0;
//        }
//        buyCar.put(product, newCount);
        clculateAndSetPartPrice(product);
        shopCarView.notifyDataSetChanged();
    }

    @Override
    public void add(Product product) {
        productBiz.add(product);

        clculateAndSetPartPrice(product);
        shopCarView.notifyDataSetChanged();
    }

    @Override
    public void checkBoxOnChanged(Product product, boolean isChecked) {
        if (isChecked) {
            product.setIsChecked(true);
        } else {
            product.setIsChecked(false);
        }
        clculateChanged();

    }



    @Override
    public void selectAllChanged(boolean isChecked) {
        if (isChecked) {
            for (Product product : shopCar.keySet()) {
                product.setIsChecked(true);
            }
        }else {
            for (Product product : shopCar.keySet()) {
                product.setIsChecked(false);
            }
        }

        shopCarView.notifyDataSetChanged();
    }

    @Override
    public void delete(Product product) {
        productBiz.delete(product);

        products.remove(product);
        shopCarView.notifyDataSetChanged();
        clculateChanged();
    }

    @Override
    public void gotoPay() {
        shopCarView.gotoPay();
    }


    private void clculateAndSetPartPrice(Product product) {
        float fPartPrice = Float.parseFloat(product.getPrice()) * Integer.parseInt(shopCar.get(product).toString());
        String sPartPrice = String.format("%.2f", fPartPrice);
        product.setPartPrice(sPartPrice);
        clculateChanged();
}

    private void clculateChanged() {
        int totalSelect = 0;
        float totalPrice=0.0f;
        for (Product product : shopCar.keySet()) {
            if (product.getIsChecked()) {
                totalSelect++;
                totalPrice+=(Float.valueOf(product.getPrice())* shopCar.get(product));
            }
        }
        shopCarView.onTotalSelect(String.valueOf(totalSelect));
        shopCarView.onTotalPrice(String.format("%.2f",totalPrice));

        // TODO: 2015/12/28 全选按钮会有bug
//        if (totalSelect==shopCar.size()){
//            shopCarView.selectAllOnSelect();
//        }else {
//            shopCarView.selectAllOnUnSelect();
//        }

    }
}
