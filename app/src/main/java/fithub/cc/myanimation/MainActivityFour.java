package fithub.cc.myanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by hosa2015 on 2016-5-16.
 */
public class MainActivityFour extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll_one;
    private ImageView iv_one;
    private RelativeLayout rl_one;
    private Button bt_start, bt_stop,bt_value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_four);
        ll_one = (LinearLayout) findViewById(R.id.ll_one);
        iv_one = (ImageView) findViewById(R.id.iv_one);
        rl_one = (RelativeLayout) findViewById(R.id.rl_one);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_stop = (Button) findViewById(R.id.bt_stop);
        bt_value = (Button) findViewById(R.id.bt_value);
        bt_start.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
        rl_one.setOnClickListener(this);
        bt_value.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                rl_one.setVisibility(View.VISIBLE);
//                ObjectAnimator one =    ObjectAnimator.ofFloat(ll_one, "translationY", 0, 300);
                ObjectAnimator two = ObjectAnimator.ofFloat(ll_one, "translationX", -800, 0);
                two.setDuration(2000);
                ObjectAnimator three = ObjectAnimator.ofFloat(iv_one, "translationX", -800, 0);
                three.setDuration(1500);
                three.setStartDelay(1000);
                ObjectAnimator four = ObjectAnimator.ofFloat(iv_one, "scaleX", 1.0f, 0.2f);
                four.setDuration(1000);
                four.setRepeatCount(4);
                four.setRepeatMode(ObjectAnimator.RESTART);
                ObjectAnimator five = ObjectAnimator.ofFloat(iv_one, "scaleY", 1.0f, 0.2f);
                five.setDuration(1000);
                five.setRepeatCount(4);
                five.setRepeatMode(ObjectAnimator.RESTART);
                ObjectAnimator six = ObjectAnimator.ofFloat(ll_one, "alpha", 1.0f, 0.0f);
                six.setDuration(2000);
                ObjectAnimator seven = ObjectAnimator.ofFloat(ll_one, "translationY", 0, -100f);
                seven.setDuration(2000);
                AnimatorSet set = new AnimatorSet();
                set.play(two).with(three);
                set.play(two).before(four);
                set.play(four).with(five);
                set.play(five).before(six);
                set.play(six).with(seven);
                set.start();
                break;
            case R.id.bt_value:
                ValueAnimator animator = ValueAnimator.ofInt(0,100);
                animator.setDuration(100*1000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Integer value = (Integer) animation.getAnimatedValue();
                        bt_value.setText("" + value);
                    }
                });
                animator.start();

                break;
            case R.id.bt_stop:
                startActivity(new Intent(this,MainActivityFive.class));

                break;


        }


    }
}
