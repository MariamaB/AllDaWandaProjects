package com.lischke.miriam.layoutexample;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lischke.miriam.layoutexample.model.TrendingProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Miriam on 02.06.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductViewHolder> {


    List<TrendingProduct> products;
    Context context;
    boolean portraitOriantation;






    public RVAdapter(List<TrendingProduct> products, Context context, boolean portraitOriantation){
        this.products = products;
        this.context = context;
        this.portraitOriantation = portraitOriantation;

    }






    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // in Dieser Methode kann ich zur Laufzeit am gesamten Layout was ändern.
        View v;
        if (portraitOriantation){
             v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2, viewGroup, false);
        }else{
             v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        }

        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int position) {
// in Dieser Methode könnte ich zur Laufzeit was an den einzelnen Elementen was ändern.
        TrendingProduct product = products.get(position);

            productViewHolder.productTitle.setText(product.getTitle());
            productViewHolder.productPrice.setText(product.getPrice().toString());
            productViewHolder.productId.setText(product.toStringId());

        if (portraitOriantation){
            Picasso.with(context).load("http:" + product.getDefault_image().getFull())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(productViewHolder.productPhoto);
        }
        else
        {
            Picasso.with(context).load("http:" + product.getDefault_image().getBig())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(productViewHolder.productPhoto);
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView productTitle;
        TextView productPrice;
        TextView productId;
        ImageView productPhoto;

        public ProductViewHolder(View itemView) {
            super(itemView);
            if (portraitOriantation){
                cv = (CardView)itemView.findViewById(R.id.cvL);
            }
            else
            {
                cv = (CardView)itemView.findViewById(R.id.cv);
            }
            productTitle = (TextView) itemView.findViewById(R.id.product_title);
            productPrice = (TextView) itemView.findViewById(R.id.product_price);
            productId = (TextView) itemView.findViewById(R.id.product_id);
            productPhoto = (ImageView) itemView.findViewById(R.id.product_photo);
        }

    }
}