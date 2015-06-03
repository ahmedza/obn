package com.onebridge.activities.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.onebridge.activities.R;
import com.onebridge.adapter.CustomArrayAdapter;
import com.onebridge.manager.AccountManager;
import com.onebridge.model.UserAddress;
import com.onebridge.model.Users;
import com.parse.ParseException;
import com.parse.SaveCallback;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AccountInfo extends Activity {
    private Users user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        user = AccountManager.getAccountManager().getUser("");
        setPersonalUi(user);
        setAddressUi(user);
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
//        Intent intent = new Intent(this,AccountEditActivity.class);
        Intent intent = new Intent(this,AccountPersonalInfo.class);
        intent.putExtra("user", user);

        startActivity(intent);
    }

    public void editAddressInfo(View view){

        View holder = (View) view.getTag(R.layout.myaccount_addresses_layout);
        UserAddress userAdd = (UserAddress)view.getTag();
//        view = holder;
        String attentionTo = userAdd.getAttentionTo();//((TextView)holder.findViewById(R.id.tv_act_edit_careOf)).getText().toString();
        String address = userAdd.getAddLine1();//((TextView)holder.findViewById(R.id.tv_act_edit_addline)).getText().toString();
        String address2 = userAdd.getAddLine2();
        String postalCode = userAdd.getPostalAdd();
        Long city = userAdd.getCity();//((TextView)holder.findViewById(R.id.tv_act_edit_post_city)).getText().toString();
        Long country = userAdd.getCountryCode();//((TextView)holder.findViewById(R.id.tv_act_edit_province_country)).getText().toString();

        ((EditText)findViewById(R.id.et_act_upd_careOf)).setText(attentionTo);
        ((EditText)findViewById(R.id.et_act_upd_addline1)).setText(address);
        ((EditText)findViewById(R.id.et_act_upd_addline2)).setText(address2);
        ((EditText)findViewById(R.id.et_act_upd_post)).setText(postalCode);
        ((EditText)findViewById(R.id.et_act_upd_city)).setText(city.toString());
        ((EditText)findViewById(R.id.et_act_upd_province)).setText(userAdd.getProvince().toString());
        ((EditText)findViewById(R.id.et_act_upd_country)).setText(userAdd.getCountryCode().toString());

        findViewById(R.id.addressList).setEnabled(false);
        View updView = findViewById(R.id.updateAddressList);
        updView.setVisibility(View.VISIBLE);
        updView.setTag(userAdd);
    }

    public void saveAddressInfo(View view){

        String attentionTo = ((EditText)findViewById(R.id.et_act_upd_careOf)).getText().toString();
        String addLine1 = ((EditText)findViewById(R.id.et_act_upd_addline1)).getText().toString();
        String addLine2 = ((EditText)findViewById(R.id.et_act_upd_addline2)).getText().toString();
        String postalCode = ((EditText)findViewById(R.id.et_act_upd_post)).getText().toString();
        String cityCode = ((EditText)findViewById(R.id.et_act_upd_city)).getText().toString();
        String province = ((EditText)findViewById(R.id.et_act_upd_province)).getText().toString();
        String country = ((EditText)findViewById(R.id.et_act_upd_country)).getText().toString();

        View updView = findViewById(R.id.updateAddressList);
        updView.setVisibility(View.GONE);

        UserAddress userAdd = (UserAddress)updView.getTag();

        userAdd.setAddLine1(addLine1);
        userAdd.setAddLine2(addLine2);
        userAdd.setAttentionTo(attentionTo);
        userAdd.setPostalAdd(postalCode);
        userAdd.setCity(Long.parseLong(cityCode));
        Long provinceLong = 0l;
        Long cityLong = 0l;
        Long countryLong = 0l;
        try{
            provinceLong = Long.parseLong(province);
            cityLong = Long.parseLong(cityCode);
            countryLong = Long.parseLong(country);
        }catch(Exception e){

        }
        userAdd.setProvince(provinceLong);
        userAdd.setCountryCode(Long.parseLong(country));

        userAdd.put("attentionTo", attentionTo);
        userAdd.put("addressLine1", addLine1);
        userAdd.put("addressLine2", addLine2);
        userAdd.put("postalCode", postalCode);
        userAdd.put("cityCode", cityLong);
        userAdd.put("stateProvinceCode", provinceLong);
        userAdd.put("countryCode", countryLong);

        userAdd.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    e.printStackTrace();
                }
                System.out.print("done");

            }
        });
        ListView addLw = (ListView)findViewById(R.id.addressList);
        CustomArrayAdapter cstmAdapter = (CustomArrayAdapter)addLw.getAdapter();

        addLw.setEnabled(true);
        addLw.setVisibility(View.GONE);
        addLw.setVisibility(View.VISIBLE);
        cstmAdapter.notifyDataSetChanged();
    }

    private void setPersonalUi(Users user) {
        if (user == null) return;
        ((TextView) findViewById(R.id.et_fname)).setText(user.getFname());
        ((TextView) findViewById(R.id.et_lname)).setText(user.getLname());
        ((TextView) findViewById(R.id.et_email)).setText(user.getEmail());
        ((TextView) findViewById(R.id.et_uname)).setText(user.getUsername());
        UserAddress add = AccountManager.getAccountManager().getAddress(user.getUserId()+"");
    }

    private void setAddressUi(Users user) {
        List<UserAddress> adds = AccountManager.getAccountManager().getAddresses(user.getUserId()+"");
        CustomArrayAdapter cstmAdapter = new CustomArrayAdapter(this, adds);
        ListView addLw = (ListView)findViewById(R.id.addressList);
        addLw.setAdapter(cstmAdapter);
    }
}