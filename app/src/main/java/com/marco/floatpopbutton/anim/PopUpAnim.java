package com.marco.floatpopbutton.anim;

import android.view.View;
import com.marco.floatpopbutton.widget.PopAnimator;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:48
 */
public class PopUpAnim extends PopAnimator {
    private int padding = 8;
    private int type;//左上右下
    int distance;

    public void doAnimOut() {
        if (views.isEmpty()) return;
        for (int i = 0; i < views.size(); i++) {
            View view = views.get(i);
            if (i == 0) {
                distance = measureHeight / 2 - view.getMeasuredHeight() / 2;
            }
            distance = distance + view.getMeasuredHeight() + padding;
            view.animate()
                    .setDuration(duration)
                    .translationY(getDirection() ? 0 : getDistance())
                    .translationX(getDirection() ? getDistance() : 0)
                    .rotation(360)
                    .alphaBy(0)
                    .alpha(alpha);
        }
    }

    /**
     * 计算距离
     *
     * @return
     */
    public int getDistance() {
        return type > 1 ? distance : -distance;
    }

    /**
     * 获取方向
     *
     * @return
     */
    public boolean getDirection() {
        //返回横向为true
        return type % 2 == 0;
    }

    public PopUpAnim setType(int type) {
        type %= 4;
        this.type = type;
        return this;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

}
