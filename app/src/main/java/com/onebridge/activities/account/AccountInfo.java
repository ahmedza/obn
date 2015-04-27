package com.onebridge.activities.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.onebridge.activities.R;
import com.onebridge.manager.AccountManager;
import com.onebridge.model.UserAddress;
import com.onebridge.model.Users;

public class AccountInfo extends Activity {
    private Users user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        user = AccountManager.getAccountManager().getUser("");

        setUi(user);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void editPersonalInfo(View view){
        Intent intent = new Intent(this,AccountEditActivity.class);
        intent.putExtra("user", user);

        startActivity(intent);
    }

    private void setUi(Users user) {
        if (user == null) return;
        ((TextView)findViewById(R.id.et_fname)).setText(user.getFname());
        ((TextView)findViewById(R.id.et_lname)).setText(user.getLname());
        ((TextView)findViewById(R.id.et_email)).setText(user.getEmail());
        ((TextView)findViewById(R.id.et_uname)).setText(user.getUsername());
     //   ((TextView)findViewById(R.id.et_)).setText(user.getEmail());

        UserAddress add = AccountManager.getAccountManager().getAddress(user.getUserId()+"");
        ((TextView)findViewById(R.id.tv_act_edit_careOf)).setText(add.getAttentionTo());
        ((TextView)findViewById(R.id.tv_act_edit_addline)).setText(add.getAddLine1()+" " + add.getAddLine2());
        ((TextView)findViewById(R.id.tv_act_edit_post_city)).setText(add.getPostalAdd()+", " + add.getCity());
        ((TextView)findViewById(R.id.tv_act_edit_province_country)).setText(add.getProvince() +" , " + add.getCountryCode() );
    }
}