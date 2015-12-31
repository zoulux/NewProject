package com.ehsy.lua.commoditylist.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.application.App;
import com.ehsy.lua.commoditylist.common.Config;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IShopCarPresenter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Lua on 2015/12/25 14:27.
 */
public class CarListAdapter extends RecyclerView.Adapter<CarListViewHolder> {
    private static final String TAG = "CarListAdapter";

    private LayoutInflater inflater;
    private List<Product> products;
    private IShopCarPresenter shopCarPresenter;

    public CarListAdapter(Context context, List<Product> products,IShopCarPresenter shopCarPresenter) {
        this.products=products;
        this.shopCarPresenter=shopCarPresenter;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public CarListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_buy_car_list, parent, false);
        CarListViewHolder viewholder=new CarListViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(CarListViewHolder holder, int position) {
        final Product product=products.get(position);

        holder.setPosition(position);
        holder.title.setText(product.getTitle());
        ImageLoader.getInstance().displayImage(Config.APP_PIC_HOST + product.getPicUrl(), holder.pic, Config.OPTIONS);
        holder.brand.setText(product.getBrand());
        holder.sku.setText(product.getSku());
        holder.original.setText(product.getOriginal());


        holder.price.setText(product.getPrice());
        holder.count.setText(App.getBuyCar().get(product).toString());

        holder.part_price.setText(product.getPartPrice());

        if (product.getIsChecked()){
            holder.select.setChecked(true);
        }else{
            holder.select.setChecked(false);
        }

        holder.reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCarPresenter.reduce(product);
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCarPresenter.add(product);
            }
        });


        holder.select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shopCarPresenter.checkBoxOnChanged(product, isChecked);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCarPresenter.delete(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}


class CarListViewHolder extends RecyclerView.ViewHolder  {

     TextView title;
     ImageView pic;
     TextView brand;
     TextView sku;
     TextView original;
     TextView price;
     TextView part_price;
     TextView count;
     CheckBox select;
     ImageView reduce;
     ImageView add;
     ImageView delete;


    private int mPosition;

    public void setPosition(int position) {
        mPosition = position;
    }

    public CarListViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.tv_title);
        pic = (ImageView) view.findViewById(R.id.iv_pic);
        brand = (TextView) view.findViewById(R.id.tv_brand);
        sku = (TextView) view.findViewById(R.id.tv_sku);
        original = (TextView) view.findViewById(R.id.tv_oriainal);
        price = (TextView) view.findViewById(R.id.tv_price);
        part_price = (TextView) view.findViewById(R.id.tv_part_compute_price);
        count = (TextView) view.findViewById(R.id.tv_count);
        select = (CheckBox) view.findViewById(R.id.cb_select_product);
        reduce = (ImageView) view.findViewById(R.id.iv_reduce);
        add = (ImageView) view.findViewById(R.id.iv_add);
        delete = (ImageView) view.findViewById(R.id.iv_delete);


    }
}