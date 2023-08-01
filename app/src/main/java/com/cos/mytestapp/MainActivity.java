package com.cos.mytestapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cos.mytestapp.adapter.ViewPagerAdapter;
import com.cos.mytestapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "MainActivity222";
    private Context mthis;

    private ActivityMainBinding _binding;
    private GestureDetector gesture;
    private boolean _isOpenSlidingDrawer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding.getRoot());

        ViewPagerSetting();
        SlidingDrawerSetting();
        //SwipeSetting();

    }


    /**
     * TODO: icon size와 상관없이 topline을 고정시킬 수 있도록 수정해야한다.
     */
    private void SlidingDrawerSetting(){
        _binding.slidingDrawer.setOnDrawerOpenListener(() -> {
            Log.d(TAG, "onCreate: drawer open ");
            _isOpenSlidingDrawer = true;
        });

        _binding.slidingDrawer.setOnDrawerCloseListener(()->{
            Log.d(TAG, "onCreate: drawer close ");
            _isOpenSlidingDrawer = false;
        });

    }

    /**
     * TODO : ViewPager 추가한 뒤로 swipe 처리 다시 확인필요
     */
    private void SwipeSetting(){
        _binding.viewPager.setOnTouchListener(new OnSwipeTouchListener(mthis){
            @Override
            public void onSwipeBottom() {
                //위 -> 아래
                Log.d("kima", "onSwipeBottom: 위-> 아래");
                if(_isOpenSlidingDrawer){
                    _binding.slidingDrawer.close();
                }
            }

            @Override
            public void onSwipeTop() {
                //아래 -> 위
                Log.d("kima", "onSwipeTop: 아래 -> 위");
                if(!_isOpenSlidingDrawer){
                    _binding.slidingDrawer.open();
                }
            }

            @Override
            public void onSwipeLeft() {
                //오른쪽 -> 왼쪽
                Log.d("kima", "onSwipeLeft: 오->왼");
            }

            @Override
            public void onSwipeRight() {
                //왼쪽 -> 오른쪽
                Log.d("kima", "onSwipeRight: 왼-> 오");

            }
        });

    }

    private void ViewPagerSetting(){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        _binding.viewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(_binding.tabLayout, _binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                tab.setText("Tab"+(position+1));
            }
        }).attach();

    }


}

