package com.example.resepmakanan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Benua extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benua);
        Button asia = (Button) findViewById(R.id.buttonasia);
    	asia.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), MakananAsia.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    	Button afrika = (Button) findViewById(R.id.buttonafrika);
    	afrika.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), MakananAfrika.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    	Button amerika = (Button) findViewById(R.id.buttonamerika);
    	amerika.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), MakananAmerika.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    	Button australia = (Button) findViewById(R.id.buttonaustralia);
    	australia.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), MakananAustralia.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    	Button eropa = (Button) findViewById(R.id.buttoneropa);
    	eropa.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), MakananEropa.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}