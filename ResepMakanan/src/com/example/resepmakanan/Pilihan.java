package com.example.resepmakanan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Pilihan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihbenuadanhelp);
        Button benua = (Button) findViewById(R.id.buttonbenua);
    	benua.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), Benua.class);
    			startActivityForResult(myIntent, 0);
    		} 
    	});
    	Button help = (Button) findViewById(R.id.buttonhelp);
    	help.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View masak) {
    			Intent myIntent = new Intent(masak.getContext(), Help.class);
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
