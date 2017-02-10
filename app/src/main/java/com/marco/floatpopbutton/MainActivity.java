package com.marco.floatpopbutton;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.marco.floatpopbutton.anim.PopCircleAnim;
import com.marco.floatpopbutton.anim.PopLeftTopAnim;
import com.marco.floatpopbutton.anim.PopUpAnim;
import com.marco.floatpopbutton.widget.PopAnimator;
import com.marco.floatpopbutton.widget.PopMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PopMenu menu;
    ArrayList<PopAnimator> animators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (PopMenu) findViewById(R.id.menu);
        animators.add(new PopUpAnim().setType(0));
        animators.add(new PopCircleAnim());
        animators.add(new PopUpAnim().setType(1));
        animators.add(new PopLeftTopAnim());
        animators.add(new PopUpAnim().setType(2));
        animators.add(new PopCircleAnim());
        animators.add(new PopUpAnim().setType(3));
        animators.add(new PopLeftTopAnim());
    }

    /**
     * 切换效果
     *
     * @param view
     */
    int index = 0;

    public void onBtnChange(View view) {
        index = (++index) % animators.size();
        menu.setPopAnimator(animators.get(index));
    }

    Handler handler = new Handler();

    public void onBtnAdd(View view) {
        Button button = new Button(this);
        button.setLayoutParams(new FrameLayout.LayoutParams(60, 60));
        button.setBackgroundResource(R.mipmap.ic_launcher);
        menu.addView(button, 0);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                menu.startAnim();
            }
        }, 100);
    }

    public void onBtnMul(View view) {
        if (menu.getChildCount() > 1) {
            menu.removeViewAt(0);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.startAnim();
                }
            }, 100);
        }
    }
}
