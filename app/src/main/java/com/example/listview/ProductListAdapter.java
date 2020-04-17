package com.example.listview;

import android.content.Context;
import android.graphics.Color;
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
    int row_index = -1;
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
        ProductRoomDatabase productRoomDatabase = ProductRoomDatabase.getDatabase(holder.itemView.getContext());
        if (productList != null) {
            Product current = productList.get(position);
            holder.productTitle.setText(current.getName());
            holder.image.setImageResource(current.getImage());
            holder.quantity.setText(String.valueOf(current.getQuantity()));

            if (row_index == position) {
                holder.itemView.setBackgroundColor(Color.parseColor("#e8e8e8"));
            } else
                holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));

            holder.itemView.setOnClickListener(v -> {
                row_index = position;
                if (row_index == 0) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(count));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 1) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 2) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 3) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 4) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 5) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 6) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 7) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
                if (row_index == 8) {
                    int count = current.getQuantity();
                    count++;
                    current.setQuantity(count);
                    holder.quantity.setText(String.valueOf(current.getQuantity()));
                    productRoomDatabase.productDao().update(current);
                }
            });
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
