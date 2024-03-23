package com.example.zorkohtt2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.zorkohtt2.R;
import com.example.zorkohtt2.adapter.CartAdapter;
import com.example.zorkohtt2.adapter.PopularAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout using inflater
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find UI elements directly
        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        RecyclerView popularRecycleView = view.findViewById(R.id.PopularRecycleView);
        // Image Slider setup
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.back, ScaleTypes.FIT));

        imageSlider.setImageList(imageList, ScaleTypes.FIT);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void doubleClick(int position) {
                // TODO: Implement double click logic
            }

            @Override
            public void onItemSelected(int position) {
                String itemMessage = "Selected Image " + position;
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show();
            }
        });

        // Popular Items
        List<String> foodName = new ArrayList<>();
        foodName.add("Pizza");
        foodName.add("Burger");
        foodName.add("Tea");
        foodName.add("Pizza");
        foodName.add("Burger");
        foodName.add("Tea");

        List<String> foodPrices = new ArrayList<>();
        foodPrices.add("$5");
        foodPrices.add("$10");
        foodPrices.add("$100");
        foodPrices.add("$5");
        foodPrices.add("$10");
        foodPrices.add("$100");

        List<Integer> foodImages = new ArrayList<>();
        foodImages.add(R.drawable.back);
        foodImages.add(R.drawable.banner1);
        foodImages.add(R.drawable.banner1);
        foodImages.add(R.drawable.back);
        foodImages.add(R.drawable.banner1);
        foodImages.add(R.drawable.banner1);

        CartAdapter cartAdapter = new CartAdapter();

        PopularAdapter adapter = new PopularAdapter(foodName, foodPrices, foodImages,cartAdapter);
        popularRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        popularRecycleView.setAdapter(adapter);

        return view;
    }
}
