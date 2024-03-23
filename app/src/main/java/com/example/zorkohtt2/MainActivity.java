package com.example.zorkohtt2;

import static androidx.navigation.Navigation.findNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.zorkohtt2.Fragments.CartFragment;
import com.example.zorkohtt2.Fragments.CommunityFragment;
import com.example.zorkohtt2.Fragments.HomeFragment;
import com.example.zorkohtt2.Fragments.MapFragment;
import com.example.zorkohtt2.Fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId== R.id.homeFragment){
                    loadFragment(new HomeFragment());
                }
                else if(itemId == R.id.cartFragment){
                    loadFragment(new CartFragment());
                }
                else if(itemId == R.id.mapFragment){
                    loadFragment(new MapFragment());
                }
                else if(itemId == R.id.communityFragment){
                    loadFragment(new CommunityFragment());
                }
                else if(itemId == R.id.profileFragment){
                    loadFragment(new ProfileFragment());
                }
                return false;
            }
        });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }
}