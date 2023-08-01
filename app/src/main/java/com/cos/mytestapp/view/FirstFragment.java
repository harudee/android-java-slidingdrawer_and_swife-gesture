package com.cos.mytestapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cos.mytestapp.R;
import com.cos.mytestapp.adapter.ViewPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class FirstFragment extends Fragment {
    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    /*@Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);

    }*/
}