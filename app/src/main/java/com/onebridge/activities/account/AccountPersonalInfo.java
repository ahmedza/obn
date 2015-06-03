package com.onebridge.activities.account;

import com.onebridge.activities.R;
import com.onebridge.model.Users;
import com.parse.ParseException;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class AccountPersonalInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_personal_info_grid);


        Users user = (Users)this.getIntent().getExtras().get("user"); //(Users)savedInstanceState.get("user");
        placeUIData(user);

    }

    private void placeUIData(Users user){
        EditText uname = (EditText)findViewById(R.id.et_personal_info_edit_username);
        EditText fname = (EditText)findViewById(R.id.et_personal_info_edit_firstname);
        EditText lname = (EditText)findViewById(R.id.et_personal_info_edit_lastname);
        Spinner gender = (Spinner)findViewById(R.id.et_personal_info_edit_gender);
        DatePicker dob = (DatePicker)findViewById(R.id.et_personal_info_edit_dob);
        EditText phone = (EditText)findViewById(R.id.et_personal_info_edit_phone);
        EditText email = (EditText)findViewById(R.id.et_personal_info_edit_email);

        uname.setText(user.getUsername());

        fname.setText(user.getFname());

        lname.setText(user.getLname());

        gender.setSelection(0);

        email.setText(user.getEmail());

//        dob.set

        findViewById(R.id.tv_EditText).setTag(user);
    }

    public void editPersonalInfo(View view){
        Users user = (Users)view.getTag();

        EditText uname = (EditText)findViewById(R.id.et_personal_info_edit_username);
        EditText fname = (EditText)findViewById(R.id.et_personal_info_edit_firstname);
        EditText lname = (EditText)findViewById(R.id.et_personal_info_edit_lastname);
        Spinner gender = (Spinner)findViewById(R.id.et_personal_info_edit_gender);
        DatePicker dob = (DatePicker)findViewById(R.id.et_personal_info_edit_dob);
        EditText phone = (EditText)findViewById(R.id.et_personal_info_edit_phone);
        EditText email = (EditText)findViewById(R.id.et_personal_info_edit_email);

//        uname.setText(user.getUsername());
        user.setFname(uname.getText().toString());
        user.setLname(lname.getText().toString());
        user.setGender(gender.getSelectedItem().toString());
        user.setEmail(email.getText().toString());
//user.saveInBackground();
        try {
            user.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
