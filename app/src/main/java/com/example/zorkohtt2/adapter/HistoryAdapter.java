package com.example.zorkohtt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R; // Assuming your layout file is in the same resource directory

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private final List<String> items;
    private final List<String> prices;
    private final List<Integer> images;

    public HistoryAdapter(List<String> items, List<String> prices, List<Integer> images) {
        this.items = items;
        this.prices = prices;
        this.images = images;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_item, parent, false); // Assuming your layout file is named history_item.xml
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        String item = items.get(position);
        String price = prices.get(position);
        int image = images.get(position);
        holder.bind(item, price, image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView historyName;
        private final TextView historyPrice;
        private final ImageView historyImage;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            historyName = itemView.findViewById(R.id.historyname); // Update these IDs based on your history_item.xml
            historyPrice = itemView.findViewById(R.id.historyprice);
            historyImage = itemView.findViewById(R.id.historyimage);
        }

        public void bind(String item, String price, int image) {
            historyName.setText(item);
            historyPrice.setText(price);
            historyImage.setImageResource(image);
        }
    }
}