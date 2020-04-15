package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Product> productList;

    ProductListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.row, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (productList != null) {
            Product current = productList.get(position);
            holder.productTitle.setText(current.getName());
            holder.image.setImageResource(current.getImage());
        } else {
            holder.productTitle.setText("No Product");
        }
    }

    void setProductList(List<Product> products) {
        productList = products;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (productList != null)
            return productList.size();
        return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private final TextView productTitle;
        private final TextView quantity;
        private final ImageView image;

        private ProductViewHolder(View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.product);
            quantity = itemView.findViewById(R.id.quantity);
            image = itemView.findViewById(R.id.image);
        }
    }


}
