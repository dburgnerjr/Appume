package com.danielburgnerjr.appume;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.ListView;

public class ContactMe extends Activity {
	
	ListView lvView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactme);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.contactmeList);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Email:  dburgnerjr@yahoo.com", 
                                         "Phone:  1-757-202-5849",
                                         "LinkedIn:  http://www.linkedin.com/in/dburgnerjr",
                                         "GitHub:  https://github.com/dburgnerjr", 
                                         "Google Play Store", 
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
                	   		String strEmail = "dburgnerjr@yahoo.com";
                	   		newActivity = new Intent(Intent.ACTION_SEND);
                	   		newActivity.putExtra(Intent.EXTRA_EMAIL, new String[]{strEmail});
                	   		newActivity.setType("plain/text");
                	   		startActivity(newActivity);
                            break;
                            
                   case 1:  
                   			String strPhone = "tel:1-757-202-5849";
                	   		newActivity = new Intent(Intent.ACTION_DIAL, Uri.parse(strPhone)); 
                	   		startActivity(newActivity);
                            break;
                           
                   case 2:  
                   			String strLinkedIn = "http://www.linkedin.com/in/dburgnerjr";
                	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strLinkedIn));     
                            startActivity(newActivity);
                            break;
                            
                   case 3:  
                	   		String strGitHub = "https://github.com/dburgnerjr";
                	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strGitHub));     
                            startActivity(newActivity);
                            break;
                         
                   case 4:  
                	   		String strPlayStore = "market://search?q=pub:Daniel Burgner, Jr.";
                	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strPlayStore));    
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
