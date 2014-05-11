package com.locomate.helper;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.inputmethod.InputMethodManager;

public class Util {
	public static void hideSoftKeyboard(Activity activity) {
		if (activity.getCurrentFocus() != null) {
			InputMethodManager inputMethodManager = (InputMethodManager) activity
					.getSystemService(Activity.INPUT_METHOD_SERVICE);

			inputMethodManager.hideSoftInputFromWindow(activity
					.getCurrentFocus().getWindowToken(), 0);
		}
	}
	
	
	
}
