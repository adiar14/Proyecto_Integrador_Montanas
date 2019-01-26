package com.example.adiar.proyecto_integrador_montanas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SplashScreen extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

       // TextView myTitle = (TextView)findViewById(R.id.textView3);
        ImageView imagen = (ImageView)findViewById(R.id.imagen_logo_inicio);
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout_splash_inicio);
       // ImageView myImage = (ImageView)findViewById(R.id.imageView);

//        // sets a Pretty Custom Font
//        Typeface myFont = Typeface.createFromAsset(getAssets(), "bromello.otf");
//        myTitle.setTypeface(myFont);

        //Typeface typeface = getResources().getFont(R.font.bromello);
        //myTitle.setTypeface(typeface);

        //implements and starts animation
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.splash_fade_in);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.splash_scale);
        anim2.setStartOffset(1500);
        layout.startAnimation(anim1);
        imagen.startAnimation(anim2);
        openApp(true);
    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent intent = new Intent(SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);*/
                finish();
            }
        }, 5000);
    }

}