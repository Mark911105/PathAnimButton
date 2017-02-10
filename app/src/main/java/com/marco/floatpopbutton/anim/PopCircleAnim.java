package com.marco.floatpopbutton.anim;

import android.view.View;
import com.marco.floatpopbutton.widget.PopAnimator;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:48
 */
public class PopCircleAnim extends PopAnimator {
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
        isShow = true;
    }
}
