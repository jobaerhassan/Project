package com.example.tab_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);


        ViewPagerMessengerAdapter adapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);//important for attaching
    }
}