package com.locomate;

import com.locomate.fragments.MenuFragment;
import com.locomate.fragments.OfferRideFragment;
import com.locomate.fragments.RequestRideFragment;
import com.locomate.fragments.SearchFragment;
import com.locomate.helper.PersistantAppData;
import com.locomate.helper.Util;
import com.locomate.layout.SlidingPaneLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity implements 
	MenuFragment.MenuItemSelectedListener{
	
	SlidingPaneLayout pane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        
        DisplayMetrics size = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(size);
		PersistantAppData.w = size.widthPixels;
		PersistantAppData.h = size.heightPixels;
        
        pane = (SlidingPaneLayout) findViewById(R.id.slider);
		pane.setPanelSlideListener(new PaneListener());
		
		if (findViewById(R.id.menu) != null) {
			android.support.v4.app.Fragment firstFragment = new MenuFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.menu, firstFragment).commit();
		}
		
		if (findViewById(R.id.fragment_container) != null) {
			Fragment categoryFragment = new SearchFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, categoryFragment).commit();
		}
		
		ImageButton button = (ImageButton) findViewById(R.id.titlebutton);
		button.setPadding(5, 5, 0, 0);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {				
				if (pane.isOpen()) {
					pane.closePane();
				} else {
					pane.openPane();
				}
			}
		});
		
    }
    
    private class PaneListener implements SlidingPaneLayout.PanelSlideListener {
		@Override
		public void onPanelClosed(View view) {
			//Util.hideSoftKeyboard(MainActivity.this);
		}

		@Override
		public void onPanelOpened(View view) {
		}

		@Override
		public void onPanelSlide(View view, float arg1) {
		}
	}

	@Override
	public void onMenuItemSelected(int position) {		
		if(position == 0){
			loadSearchFragment();
		}
		else if (position == 1){
			loadOfferRideFragment();			
		}
		else if ( position == 2){
			loadRequestRideFragment();
		}
		else if(position == 3){
			
		}
		else{
			
		}
	}
	
	public void loadOfferRideFragment() {
		
		final Fragment fragment = new OfferRideFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);		
		transaction.commit();
		pane.closePane();
	}
	
	public void loadSearchFragment() {
		final Fragment fragment = new SearchFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);
		transaction.commit();
		pane.closePane();
	}
	
	public void loadRequestRideFragment() {
		final Fragment fragment = new RequestRideFragment();
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, fragment);
		transaction.commit();
		pane.closePane();
	}

}
