package com.example.resepmakanan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends Activity {
Bundle b= new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        b = getIntent().getExtras();
        TextView tnama = (TextView) findViewById(R.id.textView1);
        tnama.setText (b.getString("Nama"));
        TextView tbahan = (TextView) findViewById(R.id.textView2);
        tbahan.setText ("Bahan : \n"+b.getString("Bahan"));
        TextView tcara = (TextView) findViewById(R.id.textView3);
        tcara.setText ("Cara Membuat : \n"+b.getString("Cara"));
        ImageView tgambar = (ImageView) findViewById(R.id.imageView1);
        int idgambar = getResources().getIdentifier(b.getString("kode"), "drawable", getPackageName());
        System.out.println(b.getString("kode"));
        System.out.println(idgambar);
        //int gambar = Integer.parseInt("R.drawable."+b.getString("kode"));
        tgambar.setImageResource(idgambar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
    
}
