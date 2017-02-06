package com.marco.floatpopbutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.marco.floatpopbutton.R;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 17:09
 */
public class PopMenu extends FrameLayout {
    private ArrayList<View> views = new ArrayList<>();
    private View menuView;//开启菜单的按钮
    PositionAnim positionAnim = new PositionAnim();
    int normalHeight;

    public PopMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(R.styleable.PopMenu);
        typedArray.recycle();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initView();

            }
        }, 100);
    }


    Handler handler = new Handler();

    public void initView() {
        if (getChildCount() < 1) return;

        for (int i = 0; i < getChildCount() - 1; i++) {
            views.add(getChildAt(i));
        }

        menuView = getChildAt(getChildCount() - 1);
        menuView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionAnim.isShow()) {
                    positionAnim.doAnimIn();
                } else {
                    positionAnim.doAnimOut();
                }
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        for (View itemView : views) {
            itemView.layout(
                    menuView.getLeft() + (menuView.getMeasuredWidth() - itemView.getMeasuredWidth()) / 2,
                    menuView.getTop() + (menuView.getMeasuredHeight() - itemView.getMeasuredHeight()) / 2,
                    menuView.getLeft() + (menuView.getMeasuredWidth() + itemView.getMeasuredWidth()) / 2,
                    menuView.getTop() + (menuView.getMeasuredHeight() + itemView.getMeasuredHeight()) / 2
                           );
            normalHeight = (menuView.getMeasuredHeight() - itemView.getMeasuredHeight())/2;
            positionAnim.setMeasureHeight(menuView.getMeasuredHeight())
                    .setNormalHeight(normalHeight)
                    .setPadding(8)
                    .setType(PopType.TOPLEFT)
                    .setViews(views);
        }
        requestLayout();
    }
}
