package com.lischke.miriam.layoutlistview;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lischke.miriam.layoutlistview.model.TrendingProduct;

import java.util.List;

/**
 * Created by Miriam on 02.06.2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<TrendingProduct> products;

    RVAdapter(List<TrendingProduct> products){
        this.products = products;

    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int position) {

        TrendingProduct product = products.get(position);

        personViewHolder.productTitle.setText(product.getTitle());
        personViewHolder.productPrice.setText(product.getPrice().toString());
        personViewHolder.productId.setText(product.toStringId());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView productTitle;
        TextView productPrice;
        TextView productId;

        public PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            productTitle = (TextView) itemView.findViewById(R.id.product_title);
            productPrice = (TextView) itemView.findViewById(R.id.product_price);
            productId = (TextView) itemView.findViewById(R.id.product_id);
        }

    }
}