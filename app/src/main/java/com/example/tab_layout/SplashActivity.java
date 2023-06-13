package com.example.tab_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {
TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        txt = findViewById(R.id.splashTxtView);
        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        txt.startAnimation(alpha);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMainActivity = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(toMainActivity);
                finish();
            }

        },3000);//3 sec delay
    }
}