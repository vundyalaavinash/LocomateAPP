package com.locomate.fragments;

import java.util.ArrayList;
import java.util.List;

import com.locomate.R;
import com.locomate.adapters.MenuAdapter;
import com.locomate.listitems.MenuListItem;

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

public class MenuFragment extends Fragment implements OnItemClickListener{
	
	private View view;
	private ListView menulistView;
	private List<MenuListItem> rowItems;
	public final String[] titles = new String[] { "Search / Near By",
		"Offer Ride", "Request Ride", "Locator" ,"Information" };
	public static Integer[] images = { R.drawable.ic_searchbar,
		R.drawable.ic_fordon,R.drawable.ic_halsa,R.drawable.ic_map_dark, R.drawable.ic_info };
	MenuItemSelectedListener mCallback;
	
	public interface MenuItemSelectedListener {
		public void onMenuItemSelected(int position);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_menu, null);	  
		menulistView = (ListView) view.findViewById(R.id.menu_list);
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		System.out.println("activity");
		createMenuTheread();
		menulistView.setOnItemClickListener(this);		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		mCallback.onMenuItemSelected(position);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallback = (MenuItemSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}
	
	public void createMenuTheread() {
		getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				System.out.println("In");
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
				
				rowItems = new ArrayList<MenuListItem>();
				for (int i = 0; i < titles.length; i++) {
					MenuListItem item = new MenuListItem(titles[i],images[i]);
					rowItems.add(item);
				}				
				menulistView = (ListView) getActivity().findViewById(R.id.menu_list);
				ColorDrawable sage = new ColorDrawable(getResources().getColor(R.color.sage));
				menulistView.setDivider(sage);
				menulistView.setDividerHeight(1);
				menulistView.setVisibility(View.VISIBLE);
				MenuAdapter adapter = new MenuAdapter(getActivity(), R.layout.listltem_menu, rowItems);
				menulistView.setAdapter(adapter);				
			}
		});
	}

}
