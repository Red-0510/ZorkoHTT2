package com.example.zorkohtt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R; // Assuming your layout file is in the same resource directory

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<String> items;
    private final List<String> prices;
    private final List<Integer> images;

    public CartAdapter(List<String> items, List<String> prices, List<Integer> images) {
        this.items = items;
        this.prices = prices;
        this.images = images;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cart_item, parent, false); // Assuming your layout file is named popular_item.xml
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        String item = items.get(position);
        String price = prices.get(position);
        int image = images.get(position);
        holder.bind(item, price, image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

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
            foodImage.setImageResource(image);
        }
    }
}
