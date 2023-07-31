package com.cos.mytestapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.cos.mytestapp.databinding.ActivityMainBinding;

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


        _binding.slidingDrawer.setOnDrawerOpenListener(() -> {
            Log.d(TAG, "onCreate: drawer open ");
            _isOpenSlidingDrawer = true;
        });

        _binding.slidingDrawer.setOnDrawerCloseListener(()->{
            Log.d(TAG, "onCreate: drawer close ");
            _isOpenSlidingDrawer = false;
        });

        _binding.llMain.setOnTouchListener(new OnSwipeTouchListener(mthis){
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


}



