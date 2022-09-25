package com.example.cec.matrixes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class OpenningActivity extends AppCompatActivity {

    TextView textview;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openning);
        textview=(TextView)findViewById(R.id.openning);
        animation= AnimationUtils.loadAnimation(this,R.anim.animation_openning);
        textview.setAnimation(animation);
        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent in=new Intent(OpenningActivity.this,MatrixMainActivity.class);
                    startActivity(in);
                    finish();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
