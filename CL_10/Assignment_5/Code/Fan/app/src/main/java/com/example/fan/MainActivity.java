package com.example.fan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.fanImage);

    }
    public void changeSpeed(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        System.out.println(view.getId());
        switch (view.getId()) {

            case (R.id.speed0):
                System.out.println(R.id.speed0);
                animation.setDuration(Integer.MAX_VALUE);
                break;
            case (R.id.speed1):
                animation.setDuration(150);
                break;
            case (R.id.speed2):
                animation.setDuration(100);
                break;
            case (R.id.speed3):
                animation.setDuration(50);
                break;
        }
        animation.setRepeatCount(Animation.INFINITE);
        imageView.setAnimation(animation);
        imageView.startAnimation(animation);
    }
}