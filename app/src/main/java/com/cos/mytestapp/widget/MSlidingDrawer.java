package com.cos.mytestapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MSlidingDrawer extends ViewGroup {


    private int _handle;
    private int _content;

    public MSlidingDrawer(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        init();
    }

    public MSlidingDrawer(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
        init();
    }

    public MSlidingDrawer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
        int handleId = attrs.getAttributeIntValue("android", "handle",0);
        int contentId = attrs.getAttributeIntValue("android", "content", 0);

        _handle = handleId;
        _content = contentId;

    }

    /**
     * 이 함수가 실행될 때 공통으로 반드시 처리해야하는 로직들을 넣을 것
     */
    private void init(){


    }

    /**
     * 뷰의 크기를 측정한다.
     * 레이아웃에 맞게 특정 크기를 설정해줘야한다.
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    /**
     * 뷰의 위치와 크기를 할당한다.
     * onMeasure을 통해서 사이즈가 결정된 후에 호출된다.
     * 부모 뷰에서 주로 쓰이며, child 뷰를 붙일 때 위치를 정해주는 데 사용한다.
     * 어플리케이션 전체를 기준으로 위치가 넘어온다
     * @param b
     * @param i     : left
     * @param i1    : top
     * @param i2    : right
     * @param i3    : bottom
     */
    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {


    }

}
