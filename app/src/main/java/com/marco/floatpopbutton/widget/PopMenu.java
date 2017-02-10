package com.marco.floatpopbutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
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
    private PopAnimator popAnimator = new PopAnimator();
    private int measureHeight;

    private boolean showShade;

    public PopMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PopMenu);
        showShade = typedArray.getBoolean(R.styleable.PopMenu_shade, false);
        typedArray.recycle();
    }

    public void initView() {
        if (getChildCount() < 1) return;
        views.clear();

        for (int i = 0; i < getChildCount() - 1; i++) {
            views.add(getChildAt(i));
            getChildAt(i).setAlpha(0);
        }

        menuView = getChildAt(getChildCount() - 1);
        menuView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
        if (menuView != null) {
            measureHeight = menuView.getMeasuredHeight();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initView();
        for (int i = 0; i < views.size(); i++) {
            View itemView = views.get(i);
            itemView.layout(
                    menuView.getLeft() + (menuView.getMeasuredWidth() - itemView.getMeasuredWidth()) / 2,
                    menuView.getTop() + (menuView.getMeasuredHeight() - itemView.getMeasuredHeight()) / 2,
                    menuView.getLeft() + (menuView.getMeasuredWidth() + itemView.getMeasuredWidth()) / 2,
                    menuView.getTop() + (menuView.getMeasuredHeight() + itemView.getMeasuredHeight()) / 2
                           );

            /**
             * 初始化内容参数
             */
            new AnimatorConfigBuild()
                    .setMeasureHeight(measureHeight)
                    .setViews(views).build(popAnimator);
        }
    }

    /**
     * 支持自定义Ianimator效果
     *
     * @param popAnimator
     */
    public void setPopAnimator(PopAnimator popAnimator) {
        this.popAnimator.saveConfig().build(popAnimator);
        this.popAnimator = popAnimator;
        startAnim();
    }

    /**
     * 开始动画
     */
    public void startAnim() {
        if (popAnimator.isShow) {
            popAnimator.doAnimIn();
            showShade();
            popAnimator.isShow = false;
        } else {
            popAnimator.doAnimOut();
            showShade();
            popAnimator.isShow = true;
        }
    }

    public void showShade() {
        this.setBackgroundColor(Color.parseColor(showShade ? "#11000000" : "#00000000"));
    }
}
