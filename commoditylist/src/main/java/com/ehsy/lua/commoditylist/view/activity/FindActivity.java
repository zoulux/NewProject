package com.ehsy.lua.commoditylist.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IFindPresenter;
import com.ehsy.lua.commoditylist.presenter.impl.FindPresenter;
import com.ehsy.lua.commoditylist.view.IFindView;
import com.ehsy.lua.commoditylist.view.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FindActivity extends AppCompatActivity implements IFindView, View.OnClickListener {
    private static final String TAG = "MainActivity";

    private RecyclerView rvContainer;
    private ProductsAdapter rvAdapter;
    private List<Product> data =new ArrayList<>();
    private Button btFind;
    private EditText etKeyWord;

    private IFindPresenter findPresenter;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        findPresenter =new FindPresenter(this);
        initViews();
    }

    private void initViews() {
        rvContainer = (RecyclerView) findViewById(R.id.rv_products);
        btFind= (Button) findViewById(R.id.bt_find);
        etKeyWord= (EditText) findViewById(R.id.et_key_word);
        fab= (FloatingActionButton) findViewById(R.id.fab);

        rvContainer.setItemAnimator(new DefaultItemAnimator());
        rvContainer.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvAdapter = new ProductsAdapter(this, data, findPresenter);
        rvContainer.setAdapter(rvAdapter);

        btFind.setOnClickListener(this);
        fab.setOnClickListener(this);
    }

    @Override
    public void onSuccess(List<Product> models) {
        data.clear();
        data.addAll(models);
        rvAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFaild(String faild) {
        Log.d(TAG, "onFaild " + "加载失败");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_find:
                findPresenter.loadData(etKeyWord.getText().toString());
                break;
            case R.id.fab:
              pay();
                break;
        }
    }

    private void pay() {
        Intent intent=new Intent(this,ShopCarActivity.class);
        startActivity(intent);
    }
}
