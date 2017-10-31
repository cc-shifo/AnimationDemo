package com.example.entryanimatordemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class EntryActivity extends AppCompatActivity {

    private static final int ANIMATION_DURATION = 3000;
    private static final float SCALE_END = 1.13F;
    private static final int[] SLASH_ARRAY = {
            R.drawable.splash0,
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash12,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16,
    };

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        mImageView = (ImageView)findViewById(R.id.iv_entry);

        Random r = new Random(SystemClock.elapsedRealtime());
        mImageView.setImageResource(SLASH_ARRAY[r.nextInt(SLASH_ARRAY.length)]);
        entryAnimated();
    }

    private void entryAnimated() {
         /**
          * programmatically 代码方式实现属性动画*/
        ObjectAnimator animX = ObjectAnimator.ofFloat(mImageView, View.SCALE_X, 1f, 1.3f);
        ObjectAnimator animY = ObjectAnimator.ofFloat(mImageView, View.SCALE_Y, 1f, 1.3f);
        AnimatorSet set = new AnimatorSet();
        /**
         * 另外一种调用方式*/
//        set.setDuration(3000).play(animX).with(animY);
//        set.start();
        set.setDuration(3000).playTogether(animX, animY);
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent);
                EntryActivity.this.finish();
            }
        });
        set.start();

        /**
         * XML方式实现属性动画*/
//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
//                R.animator.property_animator);
//        set.setTarget(mImageView);
//        set.start();
    }
}
