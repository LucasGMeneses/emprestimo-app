package com.example.emprestimoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.emprestimoapp.models.AppDatabase;
import com.example.emprestimoapp.models.entity.Equipamentos;
import com.example.emprestimoapp.pages.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Equipamentos> equipamentos;
    private TabLayout tabs;
    private ViewPager2 viewPager;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tabbar
        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);

        ViewPageAdapter adapter = new ViewPageAdapter(this);
        viewPager.setAdapter(adapter);

        String tabNames[] = {"Emprestimos", "Equipamentos"};
        new TabLayoutMediator(tabs, viewPager,(tab, position) -> {
            tab.setText(tabNames[position]);
        }).attach();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}