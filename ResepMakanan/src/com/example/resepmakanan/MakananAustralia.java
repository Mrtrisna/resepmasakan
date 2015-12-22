package com.example.resepmakanan;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MakananAustralia extends Activity implements TextWatcher, OnItemClickListener{
	private EditText					search;
	private ListView					lv;
	private DatabaseHelperAustralia		dbHelper;
	private ArrayAdapter<TableResep>	adapter;
	private List<TableResep>			listResep;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_makanan);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setEmptyView(findViewById(R.id.empty));
		search = (EditText) findViewById(R.id.editText1);
		dbHelper = DatabaseHelperAustralia.getInstance(this);
		setData();
		search.addTextChangedListener(this);
		lv.setOnItemClickListener(this);
	}

	private void setData(){
		listResep = dbHelper.getAllResep();
		adapter = new ArrayAdapter<TableResep>(this, android.R.layout.simple_expandable_list_item_1, listResep);
		lv.setAdapter(adapter);
	}

	@Override
	public void afterTextChanged(Editable arg0){}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){}

	@Override
	public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3){
		adapter.getFilter().filter(s.toString());
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long id)
	{
		// TODO Auto-generated method stub
		Bundle b = new Bundle();
		System.out.println(adapter.getItem(position).getnama());
		System.out.println(adapter.getItem(position).getResep());
		System.out.println(adapter.getItem(position).getcara());
		b.putString("Nama", adapter.getItem(position).getnama());
		b.putString("Bahan", adapter.getItem(position).getResep());
		b.putString("Cara", adapter.getItem(position).getcara());
		b.putString("kode", adapter.getItem(position).getkd_benua());

		Intent i = new Intent(this, Detail.class);
		i.putExtras(b);
		startActivity(i);

	}

}
