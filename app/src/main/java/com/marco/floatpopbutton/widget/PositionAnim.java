package com.marco.floatpopbutton.widget;

import android.view.View;
import com.marco.floatpopbutton.anim.*;

import java.util.ArrayList;

/**
 * User: KdMobiB
 * Date: 2017/2/6
 * Time: 18:40
 */
public class PositionAnim {
    private PopType type;
    private int     measureHeight, normalHeight;
    private ArrayList<View> views   = new ArrayList<>();
    private int             padding = 8;
    private IPosition iPosition;
    private boolean   isShow;

    public void doAnimOut() {
        iPosition.doAnimOut();
        isShow = true;
    }

    public void doAnimIn() {
        iPosition.doAnimIn();
        isShow = false;
    }

    public PositionAnim setNormalHeight(int normalHeight) {
        this.normalHeight = normalHeight;
        return this;
    }

    public PositionAnim setType(PopType type) {
        this.type = type;
        if (type == PopType.UP) {
            iPosition = new PopUpAnim(measureHeight, normalHeight, padding, views);
        } else if (type == PopType.BOTTOM) {
            iPosition = new PopBottomAnim(measureHeight, normalHeight, padding, views);
        } else if (type == PopType.CIRCLE) {
            iPosition = new PopCircleAnim(measureHeight, normalHeight, padding, views);
        } else if (type == PopType.LEFT) {
            iPosition = new PopLeftAnim(measureHeight, normalHeight, padding, views);
        } else if (type == PopType.RIGHT) {
            iPosition = new PopRightAnim(measureHeight, normalHeight, padding, views);
        }else if (type == PopType.TOPLEFT) {
            iPosition = new PopLeftTopAnim(measureHeight, normalHeight, padding, views);
        }else {
            iPosition = new PopUpAnim(measureHeight, normalHeight, padding, views);
        }
        return this;
    }

    public PositionAnim setPadding(int padding) {
        this.padding = padding;
        return this;
    }

    public PositionAnim setMeasureHeight(int measureHeight) {
        this.measureHeight = measureHeight;
        return this;
    }

    public PositionAnim setViews(ArrayList<View> views) {
        this.views = views;
        return this;
    }

    public boolean isShow() {
        return isShow;
    }

}
