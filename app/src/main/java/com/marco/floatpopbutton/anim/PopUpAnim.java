package com.marco.floatpopbutton.anim;

import android.view.View;
import com.marco.floatpopbutton.widget.IPosition;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:48
 */
public class PopUpAnim implements IPosition {
    int measureHeight, normalHeight, padding, duration, alpha;
    private ArrayList<View> views = new ArrayList<>();

    public PopUpAnim(int measureHeight, int normalHeight, int padding, ArrayList<View> views) {
        this(measureHeight, normalHeight, padding, 400, 1, views);
    }

    public PopUpAnim(int measureHeight, int normalHeight, int padding, int duration, int alpha, ArrayList<View> views) {
        this.measureHeight = measureHeight;
        this.normalHeight = normalHeight;
        this.padding = padding;
        this.duration = duration;
        this.alpha = alpha;
        this.views = views;
    }

    @Override
    public void doAnimOut() {
        measureHeight = normalHeight;
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            measureHeight = measureHeight + view.getMeasuredHeight() + padding;
            view.animate()
                    .setDuration(duration)
                    .translationYBy(0)
                    .translationY(-measureHeight)
                    .rotation(360)
                    .rotationBy(0)
                    .alphaBy(0)
                    .alpha(alpha);
        }
    }

    @Override
    public void doAnimIn() {
        measureHeight = normalHeight;
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            measureHeight = measureHeight + view.getMeasuredHeight() + padding;
            view.animate()
                    .setDuration(duration)
                    .translationYBy(-measureHeight)
                    .translationY(0)
                    .rotation(0)
                    .rotationBy(360)
                    .alphaBy(alpha)
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
