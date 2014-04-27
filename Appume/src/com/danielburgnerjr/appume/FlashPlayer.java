package com.danielburgnerjr.appume;

import android.app.Activity;
import android.content.Intent;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
 
public class FlashPlayer extends Activity {
 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentName cnSWF = new ComponentName("com.danielburgnerjr.appume", "com.danielburgnerjr.appume.FlashPlayer");
        Intent ineAppumeFlash = new Intent(Intent.ACTION_MAIN);
        ineAppumeFlash.setComponent(cnSWF);
        startActivity(ineAppumeFlash);
        
        //setContentView(R.layout.activity_appumesplash);
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(FlashPlayer.this, Appume.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}