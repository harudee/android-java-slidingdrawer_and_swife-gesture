package com.cos.mytestapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cos.mytestapp.view.FirstFragment;
import com.cos.mytestapp.view.SecondFragment;
import com.cos.mytestapp.view.ThirdFragment;

import org.jetbrains.annotations.NotNull;


public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter( FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    public ViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    /**
     * @param position
     * @return Fragment : 화면에 나타낼 fragment
     */
    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;

        }

    }

    /**
     * @return int : 화면에서 나타낼 페이지 수
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}
