package com.ehsy.lua.commoditylist.presenter.impl;

import android.util.Log;

import com.ehsy.lua.commoditylist.application.App;
import com.ehsy.lua.commoditylist.bean.ResponseBean;
import com.ehsy.lua.commoditylist.biz.ProductBiz;
import com.ehsy.lua.commoditylist.common.HttpListener;
import com.ehsy.lua.commoditylist.common.HttpParameters;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IFindPresenter;
import com.ehsy.lua.commoditylist.utils.CommonUtils;
import com.ehsy.lua.commoditylist.view.IFindView;
import com.google.gson.Gson;

/**
 * Created by Lua on 2015/12/24 14:58.
 */
public class FindPresenter implements IFindPresenter, HttpListener {
    private static final String TAG = "FindPresenter";
    private IFindView mainView;
    private ProductBiz productBiz;

    //    private Map<ProductModel,Integer> buyCar=new HashMap<>();

    public FindPresenter(IFindView mainView) {
        this.mainView = mainView;
        productBiz=new ProductBiz();
    }

    @Override
    public void loadData(String keyWord) {
        productBiz.loadData(keyWord,this);


//        Map<String, String> map = new HashMap<>();
//        map.put("module", "search/result");
//        map.put("keywords", keyWord);
//        map.put("page", "10");
//        map.put("sort", "price");
//        map.put("order", "asc");
//        HttpParameters parameters = new HttpParameters(map);
//        VolleyUtils.request(parameters, this);
    }

    @Override
    public void pay() {

        for (Product product : App.getBuyCar().keySet()) {
            Log.d(TAG, "pay :Title-->" + product.getTitle() + "数量：" + App.getBuyCar().get(product));
        }
    }

    @Override
    public void add(Product product) {

        Integer count = App.getBuyCar().get(product);
        if (count == null) {
            App.getBuyCar()
                    .put(product, 1);
        } else {
            App.getBuyCar()
                    .put(product, count + 1);
        }
    }

    @Override
    public void success(HttpParameters parameters) {
        String result = parameters.result;
        Gson gson = new Gson();
        ResponseBean beans = gson.fromJson(result, ResponseBean.class);

        mainView.onSuccess(beans.getSearch());
    }

    @Override
    public void faild(HttpParameters parameters) {
        mainView.onFaild(CommonUtils.parameterGetResult(parameters, "info"));

    }
}
