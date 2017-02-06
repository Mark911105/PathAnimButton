package com.marco.floatpopbutton.anim;

import android.view.View;
import com.marco.floatpopbutton.widget.IPosition;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:48
 */
public class PopCircleAnim implements IPosition {
    int measureHeight, normalHeight, padding, duration, alpha;
    private ArrayList<View> views  = new ArrayList<>();
    private int             radius = 20;

    public PopCircleAnim(int measureHeight, int normalHeight, int padding, ArrayList<View> views) {
        this(measureHeight, normalHeight, padding, 400, 1, views);
    }

    public PopCircleAnim(int measureHeight, int normalHeight, int padding, int duration, int alpha, ArrayList<View> views) {
        this.measureHeight = measureHeight;
        this.normalHeight = normalHeight;
        this.padding = padding;
        this.duration = duration;
        this.alpha = alpha;
        this.views = views;

        radius = measureHeight+radius;
    }

    @Override
    public void doAnimOut() {
        int start = 0;
        int degree = 360 / views.size();
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.animate()
                    .setDuration(duration)
                    .translationYBy(0)
                    .translationY((float) (radius * Math.sin(Math.toRadians(start + degree * i))))
                    .translationXBy(0)
                    .translationX((float) (radius * Math.cos(Math.toRadians(start + degree * i))))
                    .rotation(360)
                    .rotationBy(0)
                    .alphaBy(0)
                    .alpha(alpha);
        }
    }

    @Override
    public void doAnimIn() {
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.animate()
                    .setDuration(duration)
                    .translationY(0)
                    .translationX(0)
                    .rotation(0)
                    .rotationBy(360)
                    .alpha(0);
        }
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
