package com.danielburgnerjr.appume;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
                            break;
                            
                   case 1:  
                	   		newActivity = new Intent(Recommendations.this, RecFrankBird.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 2:  
                	   		newActivity = new Intent(Recommendations.this, RecLeeAsh.class);     
                            startActivity(newActivity);
                            break;
                            
                }
            }

         }); 

	}

}
