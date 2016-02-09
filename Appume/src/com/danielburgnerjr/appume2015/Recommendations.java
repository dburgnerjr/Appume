package com.danielburgnerjr.appume2015;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Recommendations extends Activity {
	
	ListView lvView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendations);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.recommendationsList);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Jermaine Jemmott", 
                                         "Frank M. Bird",
                                         "Lee Ash" 
                                        };
        
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        lvView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        lvView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition = position;
               
               // ListView Clicked item value
               String itemValue = (String) lvView.getItemAtPosition(position);
                  
                Intent newActivity;
                switch( position ) {
                   case 0:  
                	   		newActivity = new Intent(Recommendations.this, RecJermaineJemmott.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                            
                   case 1:  
                	   		newActivity = new Intent(Recommendations.this, RecFrankBird.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                            
                   case 2:  
                	   		newActivity = new Intent(Recommendations.this, RecLeeAsh.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                            
                }
            }

         }); 

	}

	public void prevPage(View view) {
		Intent intI = new Intent(this, Experience.class);
		startActivity(intI);
		finish();
	}

	public void nextPage(View view) {
		Intent intI = new Intent(this, ContactMe.class);
		startActivity(intI);
		finish();
	}

	public void mainMenu(View view) {
		Intent intI = new Intent(this, Appume.class);
		startActivity(intI);
		finish();
	}
	
	public boolean onKeyDown(int nKeyCode, KeyEvent keEvent) {
		String strBackMessage = "Press Experience to go to the previous screen, ";
		strBackMessage += "Contact Me to go to the next screen or Main Menu to return to main menu.";
		if (nKeyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(getApplicationContext(), strBackMessage, Toast.LENGTH_SHORT).show();
		    return true;
		}
		return super.onKeyDown(nKeyCode, keEvent);
   }

}
