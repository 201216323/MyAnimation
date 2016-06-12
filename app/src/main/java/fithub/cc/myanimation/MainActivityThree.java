package fithub.cc.myanimation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * ValueAnimator   ObjectAnimator是ValueAnimator的子类
 * Created by hosa2015 on 2016-5-16.
 */
public class MainActivityThree extends AppCompatActivity implements View.OnClickListener {

    private Button bt_start,bt_stop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_three);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(this);
        bt_stop = (Button) findViewById(R.id.bt_stop);
        bt_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                ValueAnimator animator = ValueAnimator.ofInt(0,100,200);
                animator.setDuration(5000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Integer value = (Integer) animation.getAnimatedValue();
                        bt_start.setText("" + value);
                    }
                });
                animator.start();
                break;
            case R.id.bt_stop:
                //PointF float类型的点坐标
                ValueAnimator animator1 = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {
                    @Override
                    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                        return null;
                    }
                });
                break;
        }
    }
}
