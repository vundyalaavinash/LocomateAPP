package com.locomate.fragments;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.locomate.R;
import com.locomate.fragments.OfferRideFragment.OfferRideTask;
import com.locomate.helper.NetworkUtils;
import com.locomate.helper.PersistantAppData;
import com.locomate.helper.URLHelper;


public class RequestRideFragment extends Fragment implements OnClickListener {

	private View view;
	private ArrayList<BasicNameValuePair> requestRideParams;
	Activity mactivity;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mactivity = activity;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_requestride, null);
		RadioButton regular = (RadioButton) view
				.findViewById(R.id.regular_ride);
		RadioButton oneTime = (RadioButton) view
				.findViewById(R.id.onetime_ride);

		regular.setOnClickListener(this);
		oneTime.setOnClickListener(this);

		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}
	
	@Override
	public void onClick(View v) {
		View daysView = view.findViewById(R.id.select_days_layout);
		switch (v.getId()) {
		case R.id.onetime_ride:
			daysView.setVisibility(View.GONE);
			break;
		case R.id.regular_ride:
			daysView.setVisibility(View.VISIBLE);
			break;
		}
	}
	
	
	private void onSubmit() {

		EditText edit_text = (EditText) view.findViewById(R.id.source_text);
		String from = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.destination_text);
		String to = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.car_model_text);
		String carmodel = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.source_text);
		String carno = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.amount_text);
		String amount = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.available_seats_text);
		String availableSeats = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.pickup_point_text);
		String pickupPoints = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.instructions_text);
		String instructions = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.date_text);
		String startDate = edit_text.getText().toString();

		edit_text = (EditText) view.findViewById(R.id.time_text);
		String time = edit_text.getText().toString();

		RadioButton rbutton;

		String frequency;
		rbutton = (RadioButton) view.findViewById(R.id.regular_ride);
		if (rbutton.isChecked())
			frequency = "regular";
		else
			frequency = "onetime";

		CheckBox cbox;

		StringBuilder sb = new StringBuilder();
		cbox = (CheckBox) view.findViewById(R.id.monday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.tuesday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.wednesday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.thursday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.friday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.satuday);
		sb.append(cbox.isChecked() ? 1 : 0);
		cbox = (CheckBox) view.findViewById(R.id.sunday);
		sb.append(cbox.isChecked() ? 1 : 0);

		String days = sb.toString();

		requestRideParams = new ArrayList<BasicNameValuePair>();

		requestRideParams.add(new BasicNameValuePair("username",
				PersistantAppData.user.getUserName()));
		requestRideParams.add(new BasicNameValuePair("frequency", frequency));
		requestRideParams.add(new BasicNameValuePair("from", from));
		requestRideParams.add(new BasicNameValuePair("to", to));
		requestRideParams.add(new BasicNameValuePair("startdate", startDate));
		requestRideParams.add(new BasicNameValuePair("time", time));
		requestRideParams.add(new BasicNameValuePair("days", days));
		requestRideParams.add(new BasicNameValuePair("amount", amount));
		requestRideParams
				.add(new BasicNameValuePair("instructions", instructions));
		requestRideParams
				.add(new BasicNameValuePair("pickuppoints", pickupPoints));
		requestRideParams.add(new BasicNameValuePair("availableseats",
				availableSeats));
		requestRideParams.add(new BasicNameValuePair("carmodel", carmodel));
		requestRideParams.add(new BasicNameValuePair("carnumber", carno));

		new requestRideTask().execute();

	}
	
	
	class requestRideTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPostExecute(String jsonResp) {
			// TODO Auto-generated method stub
			super.onPostExecute(jsonResp);

			JSONObject job = null;

			try {
				job = new JSONObject(jsonResp);
				String status = job.getString("status");

				if (status.compareTo("error") == 0) {
					Toast.makeText(mactivity.getApplicationContext(),
							"Requesting ride failed. Please try again", Toast.LENGTH_LONG).show();
					return;
				} else if (status.compareTo("success") == 0) {
					Toast.makeText(mactivity.getApplicationContext(),
							"Successfully added request for a ride !!!", Toast.LENGTH_LONG).show();
					return;
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String jsonResp = NetworkUtils.postData(requestRideParams,
					URLHelper.requestRideURL);

			return jsonResp;
		}
	}
	
}
