package com.lischke.miriam.layoutexample.model;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lischke.miriam.layoutexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Miriam on 20.06.2016.
 */
public class GRVAdapter extends RecyclerView.Adapter<GRVAdapter.ProductViewHolder> {

    private List<TrendingProduct> products;
    private Context context;


    public GRVAdapter(Context context, List<TrendingProduct> products) {

        this.products = products;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout_items, null);
//        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout_items, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(layoutView);
    return pvh;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int position) {
// in Dieser Methode könnte ich zur Laufzeit was an den einzelnen Elementen was ändern.
        TrendingProduct product = products.get(position);

        productViewHolder.productTitle.setText(product.getTitle());

        Picasso.with(context).load("http:" + product.getDefault_image().getFull())
                .placeholder(R.mipmap.ic_launcher)
                .into(productViewHolder.productPhoto);

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView productTitle;
        ImageView productPhoto;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cvG);
            productTitle = (TextView) itemView.findViewById(R.id.product_title);
            productPhoto = (ImageView) itemView.findViewById(R.id.product_photo);


        }
    }

}
