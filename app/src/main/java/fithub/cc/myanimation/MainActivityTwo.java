package fithub.cc.myanimation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * startAnim();
 * closeAnim();
 * Created by hosa2015 on 2016-5-16.
 */
public class MainActivityTwo extends AppCompatActivity implements View.OnClickListener {
    private int[] res = {R.id.image_a, R.id.image_b, R.id.image_c, R.id.image_d};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private Button bt_start, bt_stop;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = (ImageView) findViewById(res[i]);
            imageViewList.add(imageview);
            imageview.setOnClickListener(this);
        }
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_stop = (Button) findViewById(R.id.bt_stop);
        bt_start.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_a:
                if (flag) {
                    startAnim();
                } else {
                    closeAnim();
                }

                break;
            case R.id.image_b:
                Toast.makeText(this,"b",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_c:
                Toast.makeText(this,"c",Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_d:
                Toast.makeText(this,"d",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_start:
//                Toast.makeText(this,"bt_start",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivityTwo.this,MainActivityThree.class));
                break;
            case R.id.bt_stop:
//                Toast.makeText(this,"bt_stop",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivityTwo.this,MainActivityFour.class));
                break;
        }

    }

    private void closeAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 100 * i, 0);
            animator.setDuration(200);
            animator.setStartDelay(i * 300);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
        }
        flag = true;
    }

    private void startAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0, 100 * i);
            animator.setDuration(200);
            animator.setStartDelay(i * 300);
            animator.start();
        }
        flag = false;
    }
}
