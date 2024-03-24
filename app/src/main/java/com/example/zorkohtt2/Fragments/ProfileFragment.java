package com.example.zorkohtt2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zorkohtt2.R;
import com.example.zorkohtt2.adapter.HistoryAdapter;
import com.example.zorkohtt2.adapter.PopularAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Popular Items
        List<String> historyname = new ArrayList<>();
        historyname.add("Pizza");
        historyname.add("Burger");
        historyname.add("Tea");
        historyname.add("Pizza");
        historyname.add("Burger");
        historyname.add("Tea");

        List<String> historyprices = new ArrayList<>();
        historyprices.add("$5");
        historyprices.add("$10");
        historyprices.add("$100");
        historyprices.add("$5");
        historyprices.add("$10");
        historyprices.add("$100");

        List<Integer>historyimages = new ArrayList<>();
        historyimages.add(R.drawable.back);
        historyimages.add(R.drawable.banner1);
        historyimages.add(R.drawable.banner1);
        historyimages.add(R.drawable.back);
        historyimages.add(R.drawable.banner1);
        historyimages.add(R.drawable.banner1);

        RecyclerView historyRecycleView = view.findViewById(R.id.HistoryRecycleView);
        HistoryAdapter adapter = new HistoryAdapter(historyname, historyprices, historyimages);
        historyRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        historyRecycleView.setAdapter(adapter);

        return view;
    }
}