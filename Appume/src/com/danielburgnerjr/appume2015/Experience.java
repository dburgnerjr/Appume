package com.danielburgnerjr.appume2015;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Experience extends Activity {
	
	ListView lvView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_experience);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.experienceList);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Java Developer\nMetova",
        								 "Software Engineer\nDominion Enterprises",
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
        					newActivity = new Intent(Experience.this, ExpMetova.class);     
        					startActivity(newActivity);
        					finish();
        					break;
        					
                   case 1:  
        					newActivity = new Intent(Experience.this, ExpDominionEnt.class);     
        					startActivity(newActivity);
        					finish();
        					break;

                   case 2:  
                			newActivity = new Intent(Experience.this, ExpCDIMarine.class);     
                			startActivity(newActivity);
                			finish();
                			break;
                			
                   case 3:  
                	   		newActivity = new Intent(Experience.this, ExpSAIC.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                           
                   case 4:  
                	   		newActivity = new Intent(Experience.this, ExpTruestone.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                            
                   case 5:  
                	   		newActivity = new Intent(Experience.this, ExpUSPTO.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                           
                   case 6:  
                	   		newActivity = new Intent(Experience.this, ExpNorfolkState.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                           
                   case 7:  
                	   		newActivity = new Intent(Experience.this, ExpIkeWCS.class);     
                            startActivity(newActivity);
                            finish();
                            break;
                            
                   case 8:  
           	   				newActivity = new Intent(Experience.this, ExpIkeMT.class);     
           	   				startActivity(newActivity);
           	   				finish();
           	   				break;

                   case 9:  
           	   				newActivity = new Intent(Experience.this, ExpIkePatArm.class);     
           	   				startActivity(newActivity);
           	   				finish();
           	   				break;

                }
            }

         }); 
	}

	public void prevPage(View view) {
		Intent intI = new Intent(this, Education.class);
		startActivity(intI);
		finish();
	}

	public void nextPage(View view) {
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
		String strBackMessage = "Press Education to go to the previous screen, ";
		strBackMessage += "Recommendations to go to the next screen or Main Menu to return to main menu.";
		if (nKeyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(getApplicationContext(), strBackMessage, Toast.LENGTH_SHORT).show();
		    return true;
		}
		return super.onKeyDown(nKeyCode, keEvent);
   }

}
