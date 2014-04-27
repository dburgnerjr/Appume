package com.danielburgnerjr.appume;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Appume extends Activity {
	
	ListView lvView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appume);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.appumeList);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "What is an Appume?", 
                                         "Who Am I?",
                                         "Certifications",
                                         "Skills", 
                                         "Education", 
                                         "Experience", 
                                         "Recommendations", 
                                         "Contact Me" 
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
                	   		newActivity = new Intent(Appume.this, WhatIsAppume.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 1:  
                	   		newActivity = new Intent(Appume.this, WhoAmI.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 2:  
                	   		newActivity = new Intent(Appume.this, Certifications.class);     
                            startActivity(newActivity);
                            break;
                           
                   case 3:  
                	   		newActivity = new Intent(Appume.this, Skills.class);     
                            startActivity(newActivity);
                            break;
                           
                   case 4:  
                	   		newActivity = new Intent(Appume.this, Education.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 5:  
           	   				newActivity = new Intent(Appume.this, Experience.class);     
           	   				startActivity(newActivity);
           	   				break;

                   case 6:  
           	   				newActivity = new Intent(Appume.this, Recommendations.class);     
           	   				startActivity(newActivity);
           	   				break;

                   case 7:  
      	   					newActivity = new Intent(Appume.this, ContactMe.class);     
      	   					startActivity(newActivity);
      	   					break;

                }
              }

         }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appume, menu);
		return true;
	}

}
