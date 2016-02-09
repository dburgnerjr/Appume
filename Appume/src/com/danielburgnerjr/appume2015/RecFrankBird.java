package com.danielburgnerjr.appume2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;


public class RecFrankBird extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frankbird);
	}

	public void prevPage(View view) {
		Intent intI = new Intent(this, RecJermaineJemmott.class);
		startActivity(intI);
		finish();
	}

	public void nextPage(View view) {
		Intent intI = new Intent(this, RecLeeAsh.class);
		startActivity(intI);
		finish();
	}

	public void recommendationsMenu(View view) {
		Intent intI = new Intent(this, Recommendations.class);
		startActivity(intI);
		finish();
	}

	public void mainMenu(View view) {
		Intent intI = new Intent(this, Appume.class);
		startActivity(intI);
		finish();
	}
	
	public boolean onKeyDown(int nKeyCode, KeyEvent keEvent) {
		String strBackMessage = "Press Jermaine Jemmott to go to the previous screen, ";
		strBackMessage = "Press Lee Ash to go to the next screen, ";
		strBackMessage += "Recommendations to return to recommendations menu ";
		strBackMessage += "or Main Menu to return to main menu.";
		if (nKeyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(getApplicationContext(), strBackMessage, Toast.LENGTH_SHORT).show();
		    return true;
		}
		return super.onKeyDown(nKeyCode, keEvent);
   }

}
