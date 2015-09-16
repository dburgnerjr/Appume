package com.danielburgnerjr.appume2015;

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
import android.content.Context;
import android.content.ActivityNotFoundException;

public class ContactMe extends Activity {
	
	ListView lvView;
	String strPackName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactme);
		
		// Get ListView object from xml
        lvView = (ListView) findViewById(R.id.contactmeList);
        strPackName = getApplicationContext().getPackageName();
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Email:  dburgnerjr@yahoo.com", 
                                         "Phone:  1-757-202-5849",
                                         "LinkedIn:  http://www.linkedin.com/in/dburgnerjr",
                                         "GitHub:  https://github.com/dburgnerjr",
                                         "Twitter:  @dburgnerjr",
                                         "Stack Overflow:  http://stackoverflow.com/users/5111305/daniel-burgner",
                                         "Google Play Store", 
                                         "Rate This App",
                                         "Share This App",
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
		           	   		String strTwitter = "https://twitter.com/dburgnerjr";
		           	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strTwitter));     
		                    startActivity(newActivity);
		                    break;
		                    
                   case 5:  
		           	   		String strStackOverflow = "http://stackoverflow.com/users/5111305/daniel-burgner";
		           	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strStackOverflow));     
		                    startActivity(newActivity);
		                    break;

                   case 6:  
                	   		String strPlayStore = "market://search?q=pub:Daniel Burgner, Jr.";
                	   		newActivity = new Intent(Intent.ACTION_VIEW,  Uri.parse(strPlayStore));    
                	   		try {
                	   			startActivity(newActivity);
                	   		} catch (ActivityNotFoundException e) {
                	   			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/developer?id=Daniel Burgner, Jr.")));
                	   		}
                	   		break;
                            
                   case 7:
                	   		Uri uri = Uri.parse("market://details?id=" + strPackName);
                	   		newActivity = new Intent(Intent.ACTION_VIEW, uri);
                	   		try {
                	   			startActivity(newActivity);
                	   		} catch (ActivityNotFoundException e) {
                	   			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + strPackName)));
                	   		}
                	   		break;
                	   		
                   case 8:
                	   		try { 
                	   			newActivity = new Intent(Intent.ACTION_SEND);  
                	   			newActivity.setType("text/plain");
                	   			newActivity.putExtra(Intent.EXTRA_SUBJECT, "Appume");
                	   			String sAux = "\nLet me recommend you this application\n\n";
                	   			sAux = sAux + "https://play.google.com/store/apps/details?id=" + strPackName + "\n\n";
                	   			newActivity.putExtra(Intent.EXTRA_TEXT, sAux);  
                	   			startActivity(Intent.createChooser(newActivity, "choose one"));
                	   		} catch(Exception e) { 
                	   			//e.toString();
                	   		} 
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
