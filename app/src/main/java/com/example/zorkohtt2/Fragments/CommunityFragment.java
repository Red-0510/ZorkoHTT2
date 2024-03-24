package com.example.zorkohtt2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zorkohtt2.R;
import com.example.zorkohtt2.adapter.CommunityAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        List<String> names = new ArrayList<>();

        names.add("krunal");
        names.add("parth");
        names.add("jainesh");

        List<String> comments = new ArrayList<>();

        comments.add("good food!");
        comments.add("good food2!");
        comments.add("good food3!");

        List<String> upvotesList = new ArrayList<>();


        upvotesList.add("10");
        upvotesList.add("20");
        upvotesList.add("30");


        List<String> downvotesList = new ArrayList<>();

        downvotesList.add("1");
        downvotesList.add("2");
        downvotesList.add("3");

        RecyclerView communityRecycleView = view.findViewById(R.id.communityRecycleView);
        CommunityAdapter adapter = new CommunityAdapter(names, comments,upvotesList,downvotesList);
        communityRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        communityRecycleView.setAdapter(adapter);

        return view;
    }
}