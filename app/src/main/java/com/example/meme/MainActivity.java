package com.example.meme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
Animation topAnim,botAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        ImageView doge=findViewById(R.id.imageViewDoge);
        TextView appname=findViewById(R.id.textViewAppname);
        TextView slogan=findViewById(R.id.slogan);

        doge.setAnimation(topAnim);
        appname.setAnimation(botAnim);
        slogan.setAnimation(botAnim);
        Handler handler=new Handler();
        Intent intent=new Intent(this,meme.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },2500);
    }
}