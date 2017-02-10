package com.marco.floatpopbutton.anim;

import android.view.View;
import com.marco.floatpopbutton.widget.PopAnimator;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:48
 */
public class PopLeftTopAnim extends PopAnimator {
    public void doAnimOut() {
        if (views.isEmpty()) return;
        radius = 120;
        int start = -105;
        int degree = 120 / (views.size() + 1);
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            view.animate()
                    .setDuration(duration)
                    .translationY((float) ((radius + measureHeight) * Math.sin(Math.toRadians(start + degree * (i + 1)))))
                    .translationX((float) ((radius + measureHeight) * Math.cos(Math.toRadians(start + degree * (i + 1)))))
                    .rotation(360)
                    .alphaBy(0)
                    .alpha(alpha);
        }
        isShow = true;
    }
}
