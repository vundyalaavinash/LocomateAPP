package com.locomate;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.locomate.beans.RegistrationPO;
import com.locomate.helper.NetworkUtils;
import com.locomate.helper.PersistantAppData;
import com.locomate.helper.URLHelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	ArrayList<BasicNameValuePair> loginParams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		TextView appNameView = (TextView) findViewById(R.id.app_name);
		Typeface tf = Typeface.createFromAsset(getApplicationContext()
				.getAssets(), "fonts/gothic.otf");
		appNameView.setTypeface(tf);

		Button signin = (Button) findViewById(R.id.sign_in);
		Button signup = (Button) findViewById(R.id.sign_up);

		signin.setOnClickListener(this);
		signup.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.sign_in:
			onSignIn();
			break;
		case R.id.sign_up:
			break;
		}

	}

	class SignInTask extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPostExecute(String jsonResp) {
			// TODO Auto-generated method stub
			super.onPostExecute(jsonResp);

			JSONObject job = null;

			try {
				job = new JSONObject(jsonResp);
				String status = job.getString("status");

				if (status.compareTo("error") == 0) {
					Toast.makeText(LoginActivity.this,
							job.getString("message"), Toast.LENGTH_LONG).show();
					return;
				} else if (status.compareTo("success") == 0) {

					RegistrationPO user = new RegistrationPO();

					user.setUserName(job.getString("username"));
					user.setEmail(job.getString("email"));
					user.setFirstName(job.getString("firstname"));
					user.setLastName(job.getString("lastname"));
					user.setOccupation(job.getString("occupation"));
					user.setMobileNumber(job.getString("mobile"));
					user.setGender(job.getString("gender"));

					PersistantAppData.user = user;

					Intent i = new Intent(LoginActivity.this,
							MainActivity.class);
					startActivity(i);
					finish();

				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub

			String jsonResp = NetworkUtils.postData(loginParams,
					URLHelper.loginURL);

			return jsonResp;
		}

	}

	private void onSignIn() {

		loginParams = new ArrayList<BasicNameValuePair>();
		EditText edit_text;

		edit_text = (EditText) findViewById(R.id.username);
		String username = edit_text.getText().toString();

		edit_text = (EditText) findViewById(R.id.passsword);
		String password = edit_text.getText().toString();

		loginParams.add(new BasicNameValuePair("username", username));
		loginParams.add(new BasicNameValuePair("password", password));
		
		new SignInTask().execute();

	}
}
