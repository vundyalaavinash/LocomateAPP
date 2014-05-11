package com.locomate.fragments;

import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.locomate.R;
import com.locomate.beans.RegistrationPO;
import com.locomate.helper.NetworkUtils;
import com.locomate.helper.PersistantAppData;
import com.locomate.helper.URLHelper;

public class OfferRideFragment extends Fragment implements OnClickListener {

	private View view;
	private ArrayList<BasicNameValuePair> offerRideParams;
	Activity mactivity;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mactivity = activity;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_offerride, null);
		RadioButton regular = (RadioButton) view
				.findViewById(R.id.regular_ride);
		RadioButton oneTime = (RadioButton) view
				.findViewById(R.id.onetime_ride);

		Button offerRide = (Button) view.findViewById(R.id.submit_details);

		final EditText timeView = (EditText) view.findViewById(R.id.time_text);

		timeView.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable s) {
				EditText edittext = timeView;
				String text = edittext.getText().toString();
				int textlength = edittext.getText().length();
				if (text.endsWith(" "))
					return;
				if (textlength == 3 && !text.contains(":")) {
					edittext.setText(new StringBuilder(text).insert(
							text.length() - 1, ":").toString());
					edittext.setSelection(edittext.getText().length());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}
		});

		final EditText dateView = (EditText) view.findViewById(R.id.date_text);

		/*
		 * dateView.addTextChangedListener(new TextWatcher() {
		 * 
		 * @Override public void onTextChanged(CharSequence s, int start, int
		 * before, int count) { }
		 * 
		 * @Override public void beforeTextChanged(CharSequence s, int start,
		 * int count, int after) { }
		 * 
		 * @Override public void afterTextChanged(Editable s) { EditText
		 * edittext = dateView;
		 * 
		 * String text = edittext.getText().toString(); int textlength =
		 * edittext.getText().length(); if (text.endsWith(" ")) return; if
		 * ((textlength == 3 || textlength == 6) && !(text.charAt(3)=='/') &&
		 * !(text.charAt(6)=='/')) { edittext.setText(new
		 * StringBuilder(text).insert( text.length() - 1, "/").toString());
		 * edittext.setSelection(edittext.getText().length()); } } });
		 */

		regular.setOnClickListener(this);
		oneTime.setOnClickListener(this);
		offerRide.setOnClickListener(this);

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
		case R.id.submit_details:
			onSubmit();
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

		offerRideParams = new ArrayList<BasicNameValuePair>();

		offerRideParams.add(new BasicNameValuePair("username",
				PersistantAppData.user.getUserName()));
		offerRideParams.add(new BasicNameValuePair("frequency", frequency));
		offerRideParams.add(new BasicNameValuePair("from", from));
		offerRideParams.add(new BasicNameValuePair("to", to));
		offerRideParams.add(new BasicNameValuePair("startdate", startDate));
		offerRideParams.add(new BasicNameValuePair("time", time));
		offerRideParams.add(new BasicNameValuePair("days", days));
		offerRideParams.add(new BasicNameValuePair("amount", amount));
		offerRideParams
				.add(new BasicNameValuePair("instructions", instructions));
		offerRideParams
				.add(new BasicNameValuePair("pickuppoints", pickupPoints));
		offerRideParams.add(new BasicNameValuePair("availableseats",
				availableSeats));
		offerRideParams.add(new BasicNameValuePair("carmodel", carmodel));
		offerRideParams.add(new BasicNameValuePair("carnumber", carno));

		new OfferRideTask().execute();

	}

	class OfferRideTask extends AsyncTask<Void, Void, String> {

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
							"Creating ride failed. Please try again", Toast.LENGTH_LONG).show();
					return;
				} else if (status.compareTo("success") == 0) {
					Toast.makeText(mactivity.getApplicationContext(),
							"Successfully Create a Ride !!!", Toast.LENGTH_LONG).show();
					return;
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String jsonResp = NetworkUtils.postData(offerRideParams,
					URLHelper.offerRideURL);

			return jsonResp;
		}
	}
}