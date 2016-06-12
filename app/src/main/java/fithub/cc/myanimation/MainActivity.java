package fithub.cc.myanimation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 *ObjectAnimator
 * PropertyValuesHolder
 * AnimatorSet
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image_a;
    private Button bt_start,bt_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_a = (ImageView) findViewById(R.id.image_a);
        bt_start= (Button) findViewById(R.id.bt_start);
        bt_stop= (Button) findViewById(R.id.bt_stop);
        image_a.setOnClickListener(this);
        bt_start.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_a:
                Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_start:
                //one
//                TranslateAnimation translateAnimation = new TranslateAnimation(0,300,300,300);
//                translateAnimation.setDuration(2000);
//                translateAnimation.setFillAfter(true);
//                image_a.startAnimation(translateAnimation);
                 //two
//                ObjectAnimator.ofFloat(image_a,"rotation",0,360f).setDuration(1000).start();
//                ObjectAnimator.ofFloat(image_a,"translationX",0,200f).setDuration(1000).start();;
//                ObjectAnimator.ofFloat(image_a,"translationY",0,200f).setDuration(1000).start();;
                //three
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation",0,360f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX",0,200f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY",0,200f);
                ObjectAnimator.ofPropertyValuesHolder(image_a,p1,p2,p3).setDuration(1000).start();
                //four
//                ObjectAnimator animator1 =  ObjectAnimator.ofFloat(image_a,"rotation",0,360f);
//                animator1.setRepeatCount(2);
//                animator1.setInterpolator(new LinearInterpolator());
//                ObjectAnimator animator2 =   ObjectAnimator.ofFloat(image_a,"translationX",0,200f);
//                ObjectAnimator animator3 =  ObjectAnimator.ofFloat(image_a,"translationY",0,200f);
//                AnimatorSet set = new AnimatorSet();
////                set.playSequentially(animator1,animator2,animator3);
//                set.play(animator2).with(animator3);
//                set.play(animator1).after(animator2);
//                set.setDuration(1000);
//                set.start();
                //five
//                ObjectAnimator animator = ObjectAnimator.ofFloat(image_a,"alpha",0f,1f);
//                animator.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                        Toast.makeText(MainActivity.this,"onAnimationStart",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        Toast.makeText(MainActivity.this,"onAnimationEnd",Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                });
//                animator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        Toast.makeText(MainActivity.this,"onAnimationEnd",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                animator.setDuration(1000).start();
                break;



            case R.id.bt_stop:
                startActivity(new Intent(MainActivity.this,MainActivityTwo.class));
                break;

        }

    }
}
