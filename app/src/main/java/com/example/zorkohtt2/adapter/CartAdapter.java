package com.example.zorkohtt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R; // Assuming your layout files are in the same resource directory

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<CartItem> items = new ArrayList<>(); // Changed to hold CartItem objects

    public CartAdapter() {
    }

    @Override
    @NonNull
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cart_item, parent, false); // Assuming your layout file is named cart_item.xml
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        CartItem item = items.get(position);
        holder.bind(item.getName(), item.getPrice(), item.getImage()); // Assuming CartItem has getter methods
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<CartItem> getItems() {
        return items;
    } // Method to access items list

    class CartViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodName;
        private final TextView foodPrice;
        private final ImageView foodImage;

        public CartViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodnamecart);
            foodPrice = itemView.findViewById(R.id.foodpricecart);
            foodImage = itemView.findViewById(R.id.foodimagecart); // Assuming these are your view IDs in the layout
        }

        public void bind(String item, String price, int image) {
            foodName.setText(item);
            foodPrice.setText(price);
            foodImage.setImageResource(image); // Assuming CartItem has image data (if applicable)
        }
    }
}
