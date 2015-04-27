package com.onebridge.activities.account;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.onebridge.activities.R;
import com.onebridge.model.Users;

public class AccountEditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_address_edit);
        Users user = (Users)this.getIntent().getSerializableExtra("user");
        setUi(user);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUi(Users user){
        ((EditText)findViewById(R.id.et_edit_acc_fname)).setText(user.getFname());
        ((EditText)findViewById(R.id.et_edit_acc_lname)).setText(user.getLname());
//        ((EditText)findViewById(R.id.et_edit_acc_fname)).setText(user.get);
//        ((EditText)findViewById(R.id.et_edit_acc_fname)).setText(user.getFname());
    }
}
