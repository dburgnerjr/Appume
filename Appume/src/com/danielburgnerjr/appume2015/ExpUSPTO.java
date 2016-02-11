package com.danielburgnerjr.appume2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;


public class ExpUSPTO extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expuspto);
	}

	public void prevPage(View view) {
		Intent intI = new Intent(this, ExpTruestone.class);
		startActivity(intI);
		finish();
	}

	public void nextPage(View view) {
		Intent intI = new Intent(this, ExpNorfolkState.class);
		startActivity(intI);
		finish();
	}

	public void experienceMenu(View view) {
		Intent intI = new Intent(this, Experience.class);
		startActivity(intI);
		finish();
	}

	public void mainMenu(View view) {
		Intent intI = new Intent(this, Appume.class);
		startActivity(intI);
		finish();
	}
	
	public boolean onKeyDown(int nKeyCode, KeyEvent keEvent) {
		String strBackMessage = "Press Truestone to go to the previous screen, ";
		strBackMessage += "Norfolk State to go to the next screen, ";
		strBackMessage += "Experience to return to experience menu ";
		strBackMessage += "or Main Menu to return to main menu.";
		if (nKeyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(getApplicationContext(), strBackMessage, Toast.LENGTH_SHORT).show();
		    return true;
		}
		return super.onKeyDown(nKeyCode, keEvent);
    }

}
