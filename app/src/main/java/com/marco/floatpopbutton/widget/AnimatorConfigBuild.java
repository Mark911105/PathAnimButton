package com.marco.floatpopbutton.widget;

import android.view.View;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/9
 * Time: 15:23
 */
public class AnimatorConfigBuild {
    public int             measureHeight = 0;//菜单按钮高度
    public ArrayList<View> views         = new ArrayList<>();//弹出按钮列表
    public boolean         isShow        = false;//当前显示状态
    public long            duration      = 400;
    public int             alpha         = 1;
    public int             radius        = 20;

    public int getMeasureHeight() {
        return measureHeight;
    }

    public AnimatorConfigBuild setMeasureHeight(int measureHeight) {
        this.measureHeight = measureHeight;
        return this;
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public AnimatorConfigBuild setViews(ArrayList<View> views) {
        this.views = views;
        return this;
    }

    public boolean isShow() {
        return isShow;
    }

    public AnimatorConfigBuild setShow(boolean show) {
        isShow = show;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public AnimatorConfigBuild setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public int getAlpha() {
        return alpha;
    }

    public AnimatorConfigBuild setAlpha(int alpha) {
        this.alpha = alpha;
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public AnimatorConfigBuild setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public AnimatorConfigBuild build(PopAnimator animator) {
        if (animator == null) {
            animator = new PopAnimator();
        }
        animator.loadConfig(this);
        return this;
    }
}
