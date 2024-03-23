package com.example.zorkohtt2.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zorkohtt2.R;
public class MapFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        TextView linkText = view.findViewById(R.id.mapredirect);
        linkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.google.com/maps/search/zorko+outlets/@21.1612838,72.7615496,13z/data=!3m1!4b1?entry=ttu";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));

                // Check if the intent can be resolved (an app can handle it)
                if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
                    view.getContext().startActivity(intent);
                } else {
                    // Handle the case where no app can handle the intent (optional)
                    Toast.makeText(view.getContext(), "No app found to open this link!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}