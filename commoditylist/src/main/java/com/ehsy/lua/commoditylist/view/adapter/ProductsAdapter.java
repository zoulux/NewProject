package com.ehsy.lua.commoditylist.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ehsy.lua.commoditylist.R;
import com.ehsy.lua.commoditylist.common.Config;
import com.ehsy.lua.commoditylist.model.Product;
import com.ehsy.lua.commoditylist.presenter.IFindPresenter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Lua on 2015/12/24 13:16.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<Product> data;
    private IFindPresenter findPresenter;
    private Product currentProduct;

    public ProductsAdapter(Context context, List<Product> list, IFindPresenter presenter) {
        this.mContext = context;
        this.data = list;
        this.findPresenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_product_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      final Product product = data.get(position);

        holder.price.setText(product.getPrice().toString());
        holder.title.setText(product.getTitle().toString());
        ImageLoader.getInstance().displayImage(Config.APP_PIC_HOST + product.getBigPicUrl(), holder.pic, Config.OPTIONS);
        holder.addBuyCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPresenter.add(product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView price;
    ImageView pic;
    Button addBuyCar;

    public ViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tv_title);
        price = (TextView) itemView.findViewById(R.id.tv_price);
        pic = (ImageView) itemView.findViewById(R.id.iv_pic);
        addBuyCar = (Button) itemView.findViewById(R.id.bt_add_buy_car);
    }
}


