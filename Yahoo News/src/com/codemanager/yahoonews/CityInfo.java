package com.codemanager.yahoonews;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CityInfo extends Activity {

	// declare variables
	TextView tvCityName, tvWeather;
	RelativeLayout rl;
	String cName, w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_info);

		// variables init
		vinit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.city_info, menu);
		return true;
	}

	public void vinit() {
		// get widget id's
		tvCityName = (TextView) findViewById(R.id.tvCityName);
		tvWeather = (TextView) findViewById(R.id.tvWeather);
		rl = (RelativeLayout) findViewById(R.id.rl1);

		updateUI();
		
		//stop the service
		stopService(new Intent(getApplicationContext(),GetCityNamesService.class));
	}

	public void updateUI() {
		// get intent data
		Intent intent = getIntent();

		// get the city name
		cName = intent.getStringExtra(Main.CITY_NAME).toLowerCase();
//		Toast.makeText(getApplicationContext(), cName, Toast.LENGTH_LONG).show();

		// determine which image should be displayed according to city name
		if (cName.equals("london")) {
			rl.setBackgroundResource(R.drawable.london);

		} else if (cName.equals("berlin")) {
			rl.setBackgroundResource(R.drawable.berlin);

		} else if (cName.equals("newyork")) {
			rl.setBackgroundResource(R.drawable.newyork);

		} else if (cName.equals("paris")) {
			rl.setBackgroundResource(R.drawable.paris);

		} else {
			rl.setBackgroundColor(Color.BLACK);
		}

		// display the city name and its weather
		tvCityName.setText(cName);
		tvWeather.setText("24 Deg");
		
		// change font color of text viewes to white
		tvWeather.setTextColor(Color.WHITE);
		tvCityName.setTextColor(Color.WHITE);
	}
}
