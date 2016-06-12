package fithub.cc.myanimation;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hosa2015 on 2016-5-19.
 */
public class AnimUtils {
    Context context;
    ImageView iv_touxiang;
    int a;
    TextView tv_name;
    String name;
    TextView tv_gift;
    String giftName;
    int giftColor;
    ImageView iv_gift;
    int giftImage;
    int giftTotal;
    LinearLayout ll_one;
    boolean havaSendGift;
    LinearLayout ll_one_num;
    TextView tv_gift_num;
    int repeatCount;
    LinearLayout ll_all_one;
    Handler handler;
    int flag;

    /**
     * @param context      上下文
     * @param iv_touxiang  送礼物人的头像ImageView
     * @param a            送礼物人头像的地址
     * @param tv_name      送礼物人名字TextView
     * @param name         送礼物人名字
     * @param tv_gift      礼物名称TextView
     * @param giftName     礼物名称
     * @param giftColor    礼物名称的颜色
     * @param iv_gift      礼物ImageView
     * @param giftImage    礼物ImageView的地址
     * @param giftTotal    礼物数量
     * @param ll_one       礼物所在布局
     * @param havaSendGift 是否已经发送礼物，默认false
     * @param ll_one_num   礼物数量所在布局
     * @param tv_gift_num  礼物数量TextView
     * @param repeatCount  重复次数
     * @param ll_all_one   整体动画所在线性布局
     * @param handler      handler发送重复次数
     * @param flag         handler的标识
     */
    public AnimUtils(Context context, int flag, ImageView iv_touxiang, int a, TextView tv_name, String name, TextView tv_gift, String giftName, int giftColor, ImageView iv_gift, int giftImage, int giftTotal, LinearLayout ll_one, boolean havaSendGift, LinearLayout ll_one_num, TextView tv_gift_num, int repeatCount, LinearLayout ll_all_one, Handler handler) {
        this.context = context;
        this.iv_touxiang = iv_touxiang;
        this.a = a;
        this.tv_name = tv_name;
        this.name = name;
        this.tv_gift = tv_gift;
        this.giftName = giftName;
        this.giftColor = giftColor;
        this.iv_gift = iv_gift;
        this.giftImage = giftImage;
        this.giftTotal = giftTotal;
        this.ll_one = ll_one;
        this.havaSendGift = havaSendGift;
        this.ll_one_num = ll_one_num;
        this.tv_gift_num = tv_gift_num;
        this.repeatCount = repeatCount;
        this.ll_all_one = ll_all_one;
        this.handler = handler;
        this.flag = flag;
    }


    public void loadAnimation() {
        iv_touxiang.setImageResource(a);
        tv_name.setText(name);
        tv_gift.setText(giftName);
        tv_gift.setTextColor(context.getResources().getColor(giftColor));
        iv_gift.setImageResource(giftImage);

        ll_one.setAlpha(1.0f);
        TranslateAnimation animation1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        animation1.setDuration(800);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                havaSendGift = true;

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
                                repeatCount = 1;
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
                        if (flag == 1) {
                            message.what = 0x123;
                        }
                        if (flag == 2) {
                            message.what = 0x124;
                        }

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
