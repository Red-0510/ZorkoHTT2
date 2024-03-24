package com.example.zorkohtt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R; // Assuming your layout files are in the same resource directory

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private final List<String> items;
    private final List<String> prices;
    private final List<Integer> images;
    private final CartAdapter cartAdapter;
    private RecyclerView recyclerViewCart; // Reference to the RecyclerView using CartAdapter

    public PopularAdapter(List<String> items, List<String> prices, List<Integer> images, CartAdapter cartAdapter) {
        this.items = items;
        this.prices = prices;
        this.images = images;
        this.cartAdapter = cartAdapter;
    }

    @Override
    @NonNull
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.popular_item, parent, false); // Assuming your layout file is named popular_item.xml
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        String item = items.get(position);
        String price = prices.get(position);
        int image = images.get(position);
        holder.bind(item, price, image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PopularViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodNamePopular;
        private final TextView foodPricePopular;
        private final ImageView foodImagePopular;

        public PopularViewHolder(View itemView) {
            super(itemView);
            foodNamePopular = itemView.findViewById(R.id.foodnamepopular);
            foodPricePopular = itemView.findViewById(R.id.foodpricepopular);
            foodImagePopular = itemView.findViewById(R.id.foodimagepopular);

            itemView.findViewById(R.id.addtocartpopular).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    String itemName = items.get(position);
                    String itemPrice = prices.get(position);
                    Integer itemImage = images.get(position);

                    CartAdapter cartAdapter = (CartAdapter) recyclerViewCart.getAdapter();
                    if (cartAdapter != null) {
                        cartAdapter.getItems().add(new CartItem(itemName, itemPrice,itemImage)); // Assuming CartItem class exists
                        cartAdapter.notifyDataSetChanged();
                        Toast.makeText(v.getContext(), "Added " + itemName + " to cart!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(v.getContext(), "Cart not found!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bind(String item, String price, int image) {
            foodNamePopular.setText(item);
            foodPricePopular.setText(price);
            foodImagePopular.setImageResource(image);
        }
    }
}