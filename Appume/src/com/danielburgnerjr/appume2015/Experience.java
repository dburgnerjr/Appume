package com.danielburgnerjr.appume2015;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Experience extends Activity {
	
	ListView lvView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_experience);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.experienceList);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Software Engineer\nDominion Enterprises",
        								 "Programmer\nCDI Marine Company",
        								 "Software Engineer\nSAIC", 
                                         "Software Engineer\nTruestone",
                                         "Patent Examiner\nUnited States Patent and Trademark Office",
                                         "Laboratory Assistant\nNorfolk State University", 
                                         "Work Center Supervisor\nUS Navy (USS Dwight D. Eisenhower)", 
                                         "Maintenance Technician\nUS Navy (USS Dwight D. Eisenhower)", 
                                         "Patrolman/Armorer\nUS Navy (USS Dwight D. Eisenhower)", 
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
        					newActivity = new Intent(Experience.this, ExpDominionEnt.class);     
        					startActivity(newActivity);
        					break;
        					
                   case 1:  
                			newActivity = new Intent(Experience.this, ExpCDIMarine.class);     
                			startActivity(newActivity);
                			break;
                			
                   case 2:  
                	   		newActivity = new Intent(Experience.this, ExpSAIC.class);     
                            startActivity(newActivity);
                            break;
                           
                   case 3:  
                	   		newActivity = new Intent(Experience.this, ExpTruestone.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 4:  
                	   		newActivity = new Intent(Experience.this, ExpUSPTO.class);     
                            startActivity(newActivity);
                            break;
                           
                   case 5:  
                	   		newActivity = new Intent(Experience.this, ExpNorfolkState.class);     
                            startActivity(newActivity);
                            break;
                           
                   case 6:  
                	   		newActivity = new Intent(Experience.this, ExpIkeWCS.class);     
                            startActivity(newActivity);
                            break;
                            
                   case 7:  
           	   				newActivity = new Intent(Experience.this, ExpIkeMT.class);     
           	   				startActivity(newActivity);
           	   				break;

                   case 8:  
           	   				newActivity = new Intent(Experience.this, ExpIkePatArm.class);     
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
