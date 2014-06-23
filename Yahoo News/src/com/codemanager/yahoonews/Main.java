package com.codemanager.yahoonews;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	// declare variables
	ListView lv;
	ArrayList<String> cities;
	ArrayAdapter<String> adapter;
	public final static String CITY_NAME = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// bootstrap routine
		vinit();

		// add onClickListener method to the list view
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int pos,
					long id) {
				Intent intent = new Intent(getApplicationContext(),
						CityInfo.class);
				String s = lv.getItemAtPosition(pos).toString();
				intent.putExtra(CITY_NAME, s);
				Intent serviceIntent = new Intent(getApplicationContext(),GetCityNamesService.class);
				startService(serviceIntent);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void vinit() {
		// get the widget id's
		lv = (ListView) findViewById(R.id.lvCities);

		// array list init
		cities = new ArrayList<String>();

		// populate the array list with cities
		cities.add("London");
		cities.add("Berlin");
		cities.add("NewYork");
		cities.add("Paris");
		cities.add("New Delhi");
		cities.add("Hong Kong");
		cities.add("Beijing");
		cities.add("Milan");
		cities.add("Madrid");
		cities.add("Cairo");
		cities.add("Brussles");
		cities.add("Rome");
		cities.add("Mexico City");
		cities.add("Barcelona");

		// adapter init
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, cities) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView textView = (TextView) view
						.findViewById(android.R.id.text1);
				/* YOUR CHOICE OF COLOR */
				textView.setTextColor(Color.WHITE);
				return view;
			}
		};

		// plug the list view into the adapter
		lv.setAdapter(adapter);
	}
}
