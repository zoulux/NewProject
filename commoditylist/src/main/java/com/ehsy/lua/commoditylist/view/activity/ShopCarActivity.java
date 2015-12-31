package com.ehsy.lua.commoditylist.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IShopCarPresenter;
import com.ehsy.lua.commoditylist.presenter.impl.ShopCarPresenter;
import com.ehsy.lua.commoditylist.view.widget.DividerItemDecoration;
import com.ehsy.lua.commoditylist.view.IShopCarView;
import com.ehsy.lua.commoditylist.view.adapter.CarListAdapter;

import java.util.ArrayList;
import java.util.List;


public class ShopCarActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, IShopCarView {
    private static final String TAG = "ShopCarActivity";

    private CheckBox cbAll;
    private TextView tvSelectedGoods;
    private TextView tvAllCoupter;
    private Button btAllCoupter;

    private RecyclerView rvBuyCar;
    private CarListAdapter shopCarAdapter;
    private List<Product> products = new ArrayList<>();

    private IShopCarPresenter shopCarPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        cbAll.setChecked(true);
        shopCarPresenter.loadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_car);
        shopCarPresenter = new ShopCarPresenter(this,products);
        initViews();
    }

    private void initViews() {

        rvBuyCar = (RecyclerView) findViewById(R.id.rv_buy_car);
        cbAll = (CheckBox) findViewById(R.id.cb_all);
        tvSelectedGoods = (TextView) findViewById(R.id.tv_select_goods);
        tvAllCoupter = (TextView) findViewById(R.id.tv_all_compute);
        btAllCoupter = (Button) findViewById(R.id.bt_all_coupter);

        cbAll.setOnCheckedChangeListener(this);
        btAllCoupter.setOnClickListener(this);

        shopCarAdapter = new CarListAdapter(this, products,shopCarPresenter);
        rvBuyCar.setLayoutManager(new LinearLayoutManager(this));
        rvBuyCar.setItemAnimator(new DefaultItemAnimator());
         rvBuyCar.setAdapter(shopCarAdapter);

        rvBuyCar.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        shopCarPresenter.selectAllChanged(isChecked);
    }

    @Override
    public void onClick(View v) {
        shopCarPresenter.gotoPay();
    }

    @Override
    public void onDataLoaded(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        shopCarAdapter.notifyDataSetChanged();
    }


    @Override
    public void gotoPay() {
        Toast.makeText(ShopCarActivity.this, "支付宝付款："+tvAllCoupter.getText().toString()+"元", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notifyDataSetChanged() {
        shopCarAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTotalSelect(String totalSelect) {
        tvSelectedGoods.setText(totalSelect);
    }

    @Override
    public void selectAllOnSelect() {
        cbAll.setChecked(true);
    }

    @Override
    public void selectAllOnUnSelect() {
        cbAll.setChecked(false);
    }

    @Override
    public void onTotalPrice(String totalPrice) {
        tvAllCoupter.setText(totalPrice);
    }
}
