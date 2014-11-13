package com.quest.universe;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.quest.second.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	
	
	private List<String> myList;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myList = new ArrayList<String>();   

        String root_sd = Environment.getExternalStorageDirectory().toString();
        //File file = new File( root_sd + "/external_sd" ) ;
        File file = new File( "/media" ) ;
        File list[] = file.listFiles();

        for( int i=0; i< list.length; i++)
        {
                myList.add( list[i].getName() );
        }

        
        for( int i=0; i< myList.size(); i++)
        {
	        File imgFile = new  File(myList.get(i) );
	        if(imgFile.exists()){
	
	            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
	            
	            ImageView iv = new ImageView(this);
	            iv.setImageBitmap(myBitmap);
	            RelativeLayout rl = (RelativeLayout) findViewById(R.id.showImagesLayout);
	            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
	                RelativeLayout.LayoutParams.WRAP_CONTENT,
	                RelativeLayout.LayoutParams.WRAP_CONTENT);
	            //lp.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
	            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
	            rl.addView(iv, lp);
	
	        }
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

