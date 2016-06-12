package fithub.cc.myanimation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hosa2015 on 2016-5-18.
 */
public class MainActivityFive extends FragmentActivity implements View.OnClickListener {
    private Button button, bt_two;
    private LinearLayout ll_all_one, ll_one, ll_one_num,ll_all_two,ll_two,ll_two_num;
    //                 送礼物人的头像 送的礼物
    private ImageView iv_touxiang, iv_gift,iv_touxiang_two,iv_gift_two;
    //           送礼物人的名字  送的礼物  礼物数量
    private TextView tv_name, tv_gift, tv_gift_num,tv_name_two,tv_gift_two,tv_gift_num_two;
    private int repeatCount = 1;
    private int giftTotal;
    private Handler handler;
    private boolean havaSendGift;//通过这个布尔值限制不能重复点送礼物，只能这个送礼物过程结束后才可以再送礼物

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        initView();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:
                if (!havaSendGift){
//                    loadAnimation(R.mipmap.aaa,"我是常灿光","送你一朵玫瑰花。。。",R.color.colorAccent,R.mipmap.shampoo,10);
                    AnimUtils animUtils = new AnimUtils(this,1,iv_touxiang,R.mipmap.aaa,tv_name,"我是常灿光",tv_gift,"送你一朵玫瑰花。。。",R.color.colorAccent,iv_gift,R.mipmap.shampoo,10,ll_one,false,ll_one_num,tv_gift_num,1,ll_all_one,handler);
                    animUtils.loadAnimation();
                }
                break;
            case R.id.bt_two:
                AnimUtils animUtilsTwo = new AnimUtils(this,2,iv_touxiang_two,R.mipmap.aaa,tv_name_two,"我是常灿光",tv_gift_two,"送你一朵玫瑰花。。。",R.color.colorAccent,iv_gift_two,R.mipmap.shampoo,10,ll_two,false,ll_two_num,tv_gift_num_two,1,ll_all_two,handler);
                animUtilsTwo.loadAnimation();

                break;
        }
    }

    public void initView(){
        button = (Button) findViewById(R.id.bt_one);
        button.setOnClickListener(this);
        ll_all_one = (LinearLayout) findViewById(R.id.ll_all_one); ll_all_two = (LinearLayout) findViewById(R.id.ll_all_two);
        ll_one = (LinearLayout) findViewById(R.id.ll_one);ll_two = (LinearLayout) findViewById(R.id.ll_two);
        ll_one_num = (LinearLayout) findViewById(R.id.ll_one_num);ll_two_num = (LinearLayout) findViewById(R.id.ll_two_num);

        iv_touxiang = (ImageView) findViewById(R.id.iv_touxiang);iv_touxiang_two = (ImageView) findViewById(R.id.iv_touxiang_two);
        iv_gift = (ImageView) findViewById(R.id.iv_gift);iv_gift_two = (ImageView) findViewById(R.id.iv_gift_two);


        bt_two = (Button) findViewById(R.id.bt_two);
        bt_two.setOnClickListener(this);

        tv_name = (TextView) findViewById(R.id.tv_name);tv_name_two = (TextView) findViewById(R.id.tv_name_two);
        tv_gift = (TextView) findViewById(R.id.tv_name);tv_gift_two = (TextView) findViewById(R.id.tv_gift_two);
        tv_gift_num = (TextView) findViewById(R.id.tv_gift_num); tv_gift_num_two = (TextView) findViewById(R.id.tv_gift_num_two);
        ll_one.setAlpha(0);ll_two.setAlpha(0);
        iv_gift.setAlpha(0);iv_gift_two.setAlpha(0);
        ll_one_num.setAlpha(0);ll_two_num.setAlpha(0);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    tv_gift_num.setText(msg.obj.toString());
                }if (msg.what ==0x124){
                    tv_gift_num_two.setText(msg.obj.toString());
                }
            }
        };
    }

    public void loadAnimation(int a,String name,String giftName,int giftColor,int giftImage,int giftTotals) {
        iv_touxiang.setImageResource(a);
        tv_name.setText(name);
        tv_gift.setText(giftName);
        tv_gift.setTextColor(getResources().getColor(giftColor));
        iv_gift.setImageResource(giftImage);
        giftTotal = giftTotals;
        ll_one.setAlpha(1.0f);
        TranslateAnimation  animation1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        animation1.setDuration(800);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                havaSendGift=true;

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                        AnimationSet animationSet1 = new AnimationSet(true);
                ll_one_num.setAlpha(1);
                ScaleAnimation animation2 = new ScaleAnimation(Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation2.setDuration(500);
                animation2.setRepeatCount(giftTotal - 1);
                animation2.setRepeatMode(Animation.RESTART);
                animation2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        iv_gift.setAlpha(255);
                        TranslateAnimation animation3 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT, 0f);
                        animation3.setDuration(800);
                        iv_gift.startAnimation(animation3);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        AnimationSet animationSet = new AnimationSet(true);
                        TranslateAnimation animation4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f);
                        AlphaAnimation animation5 = new AlphaAnimation(1, 0);
                        animationSet.addAnimation(animation4);
                        animationSet.addAnimation(animation5);
                        animationSet.setDuration(2000);
                        animationSet.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                ll_one.setAlpha(0);
                                iv_gift.setAlpha(0);
                                ll_one_num.setAlpha(0);
                                tv_gift_num.setText("1");
                                giftTotal = 1;
                                repeatCount=1;
                                havaSendGift = false;

                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        ll_all_one.startAnimation(animationSet);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        repeatCount++;
                        Log.d("---------", "aa" + repeatCount);
                        Message message = new Message();
                        message.obj = repeatCount;
                        message.what = 0x123;
                        handler.sendMessage(message);

                    }
                });
                ll_one_num.startAnimation(animation2);


            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ll_one.startAnimation(animation1);
    }

}
