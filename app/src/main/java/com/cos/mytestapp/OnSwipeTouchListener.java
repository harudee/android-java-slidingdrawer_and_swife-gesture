package com.cos.mytestapp;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public void onSwipeRight(){}
    public void onSwipeLeft(){}
    public void onSwipeTop(){}
    public void onSwipeBottom(){}

    public OnSwipeTouchListener(Context mthis){
        gestureDetector = new GestureDetector(mthis, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener{
        //스와이프 속도 보통 200~400pps
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            boolean result = false;

            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if(Math.abs(diffX) > Math.abs(diffY)){

                //
                if(Math.abs(diffX) > SWIPE_THRESHOLD
                        && Math.abs(diffX) > SWIPE_VELOCITY_THRESHOLD){

                    if(diffX > 0 )
                        onSwipeRight();
                    else
                        onSwipeLeft();

                }

                result = true;

            } else {

                if(Math.abs(diffY) > SWIPE_THRESHOLD
                        && Math.abs(diffY) > SWIPE_VELOCITY_THRESHOLD){

                    if(diffY > 0)
                        onSwipeBottom();
                    else
                        onSwipeTop();

                }

                result = true;
            }

            return result;

        }
    }

}

