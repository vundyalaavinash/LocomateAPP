package com.locomate;

import com.locomate.helper.GPSTracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen  extends Activity  {
	private static int SPLASH_TIME_OUT = 4000;
	private static int SPLASH_TIME_JUST_OUT = 1000;
	GPSTracker gpsTracker;
	boolean isFromLocationService = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
			}
		}, SPLASH_TIME_OUT);
		gpsTracker = new GPSTracker(this);
		if (!gpsTracker.canGetLocation()) {
			isFromLocationService = true;
			Intent gpsOptionsIntent = new Intent(
					android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(gpsOptionsIntent);
		} else {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent i = new Intent(SplashScreen.this, LoginActivity.class);
					startActivity(i);
					finish();
				}
			}, SPLASH_TIME_JUST_OUT);
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		gpsTracker = new GPSTracker(this);
		if (isFromLocationService) {
			if (!gpsTracker.canGetLocation()) {
				Intent gpsOptionsIntent = new Intent(
						android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(gpsOptionsIntent);
			} else {
				if (isFromLocationService) {
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent i = new Intent(SplashScreen.this,
									MainActivity.class);
							startActivity(i);
							finish();
						}
					}, SPLASH_TIME_JUST_OUT);
				}
			}
		}
	}
}
