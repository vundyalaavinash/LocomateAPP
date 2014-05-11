package com.locomate.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.locomate.R;
import com.locomate.adapters.MenuAdapter;
import com.locomate.fragments.MenuFragment.MenuItemSelectedListener;
import com.locomate.listitems.MenuListItem;

public class SearchFragment extends Fragment implements OnItemClickListener{
	
	private View view;
	private ListView menulistView;
	private List<MenuListItem> rowItems;	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_main, null);	  
		//menulistView = (ListView) view.findViewById(R.id.menu_list);
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//menulistView.setOnItemClickListener(this);		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		
	}
}
