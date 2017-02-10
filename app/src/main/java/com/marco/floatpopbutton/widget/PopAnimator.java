package com.marco.floatpopbutton.widget;

import android.view.View;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:32
 */
public class PopAnimator {
    public int             measureHeight = 0;//菜单按钮高度
    public ArrayList<View> views         = new ArrayList<>();//弹出按钮列表
    public boolean         isShow        = false;//当前显示状态
    public long            duration      = 400;
    public int             alpha         = 1;
    public int             radius        = 20;

    public void loadConfig(AnimatorConfigBuild config) {
        measureHeight = config.getMeasureHeight();
        views = config.getViews();
        isShow = config.isShow();
        duration = config.getDuration();
        alpha = config.getAlpha();
        radius = config.getRadius();
    }

    public AnimatorConfigBuild saveConfig() {
        return new AnimatorConfigBuild().setAlpha(alpha)
                .setDuration(duration)
                .setMeasureHeight(measureHeight)
                .setRadius(radius)
                .setShow(isShow)
                .setViews(views);
    }

    /**
     * 重写动画效果
     */
    public void doAnimOut() {
        if (views.isEmpty()) return;
        int start = 0;
        int degree = 360 / views.size();
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.animate()
                    .setDuration(duration)
                    .translationY((float) ((radius + measureHeight) * Math.sin(Math.toRadians(start + degree * i))))
                    .translationX((float) ((radius + measureHeight) * Math.cos(Math.toRadians(start + degree * i))))
                    .rotation(360)
                    .alphaBy(0)
                    .alpha(alpha);
        }
    }

    public void doAnimIn() {
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.animate()
                    .setDuration(duration)
                    .translationY(0)
                    .translationX(0)
                    .rotation(0)
                    .alpha(0);
        }
    }
}
