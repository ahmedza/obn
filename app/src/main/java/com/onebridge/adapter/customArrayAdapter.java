package com.onebridge.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onebridge.activities.R;
import com.onebridge.model.UserAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/17/2015.
 */
public class CustomArrayAdapter extends BaseAdapter {

    /*********** Declare Used Variables *********/
    private Activity activity;
   private List<UserAddress> data;
    private static LayoutInflater inflater=null;

    UserAddress tempValues=null;
    int i=0;

    /*************  CustomAdapter Constructor *****************/
    public CustomArrayAdapter(Activity a, List<UserAddress> d) {

        /********** Take passed values **********/
        activity = a;
        data=d;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class AddressHolder{

        public TextView tv_address;
        public TextView tv_city;
        public TextView tv_country;
        public TextView tv_attentionTo;
        public Long userId = 0L;
        public UserAddress data = new UserAddress();
       }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;


            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.myaccount_addresses_layout, null);

            AddressHolder holder = new AddressHolder();
            holder.tv_attentionTo = ((TextView)vi.findViewById(R.id.tv_act_edit_careOf));
            holder.tv_attentionTo.setText(data.get(position).getAttentionTo());
            holder.tv_address = ((TextView)vi.findViewById(R.id.tv_act_edit_addline));
            holder.tv_address.setText(data.get(position).getAddLine1().concat(" ").concat(data.get(position).getAddLine2()));;
            holder.tv_city = ((TextView)vi.findViewById(R.id.tv_act_edit_post_city));
            holder.tv_city.setText(data.get(position).getCity().toString());
            holder.tv_country = ((TextView)vi.findViewById(R.id.tv_act_edit_province_country));
            holder.tv_country.setText(data.get(position).getCountryCode().toString());
            /****** View Holder Object to contain tabitem.xml file elements ******/
            TextView tv_EditText = (TextView) vi.findViewById(R.id.tv_EditText);
            /******** Set Item Click Listner for LayoutInflater for each row *******/
            holder.userId = data.get(position).getAddressId();
            tv_EditText.setTag(R.layout.myaccount_addresses_layout,vi);
            tv_EditText.setTag(data.get(position));
//            vi.setOnClickListener(new OnItemClickListener( position ));
            holder.data = data.get(position);
        return vi;
    }

/*    public void onClick(View v) {
        *//*Log.v("CustomAdapter", "===== Row button clicked =====");*//*
        System.out.print("Hellow************************************************INSIDE CLICL ************************************");
    }*/

    //********* Called when Item click in ListView ************//
/*
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View view) {
            System.out.println("hello");
*/
/*            if(view.getClass().getName().equals(LinearLayout.class.getName())){
                return ;
            }*//*

            editAddressInfo(view);
        }


        public void editAddressInfo(View view){

            String attentionTo = ((TextView)activity.findViewById(R.id.tv_act_edit_careOf)).getText().toString();
            String address = ((TextView)activity.findViewById(R.id.tv_act_edit_addline)).getText().toString();
            String city = ((TextView)activity.findViewById(R.id.tv_act_edit_post_city)).getText().toString();
            String country = ((TextView)activity.findViewById(R.id.tv_act_edit_province_country)).getText().toString();

            ((EditText)activity.findViewById(R.id.et_act_edit_careOf)).setText(attentionTo);
            ((EditText)activity.findViewById(R.id.et_act_edit_addline)).setText(address);
            ((EditText)activity.findViewById(R.id.et_act_edit_post_city)).setText(city);
            ((EditText)activity.findViewById(R.id.et_act_edit_province_country)).setText(country);


            ((TextView)activity.findViewById(R.id.tv_act_edit_careOf)).setVisibility(View.GONE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_addline)).setVisibility(View.GONE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_post_city)).setVisibility(View.GONE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_province_country)).setVisibility(View.GONE);
            ((EditText)activity.findViewById(R.id.et_act_edit_careOf)).setVisibility(View.VISIBLE);
            ((EditText)activity.findViewById(R.id.et_act_edit_addline)).setVisibility(View.VISIBLE);
            ((EditText)activity.findViewById(R.id.et_act_edit_post_city)).setVisibility(View.VISIBLE);
            ((EditText)activity.findViewById(R.id.et_act_edit_province_country)).setVisibility(View.VISIBLE);

*/
/*        ((TextView)findViewById(R.id.tv_act_edit_careOf)).setText(add.getAttentionTo());
        ((TextView)findViewById(R.id.tv_act_edit_addline)).setText(add.getAddLine1()+" " + add.getAddLine2());
        ((TextView)findViewById(R.id.tv_act_edit_post_city)).setText(add.getPostalAdd()+", " + add.getCity());
        ((TextView)findViewById(R.id.tv_act_edit_province_country)).setText(add.getProvince() +" , " + add.getCountryCode() );*//*

        }

        public void saveAddressInfo(View view){

            String attentionTo = (String)((EditText)activity.findViewById(R.id.et_act_edit_careOf)).getText().toString();
            String address = (String)((EditText)activity.findViewById(R.id.et_act_edit_addline)).getText().toString();
            String city = (String)((EditText)activity.findViewById(R.id.et_act_edit_post_city)).getText().toString();
            String country = (String)((EditText)activity.findViewById(R.id.et_act_edit_province_country)).getText().toString();

            ((TextView)activity.findViewById(R.id.tv_act_edit_careOf)).setText(attentionTo);
            ((TextView)activity.findViewById(R.id.tv_act_edit_addline)).setText(address);
            ((TextView)activity.findViewById(R.id.tv_act_edit_post_city)).setText(city);
            ((TextView)activity.findViewById(R.id.tv_act_edit_province_country)).setText(country);


            ((TextView)activity.findViewById(R.id.tv_act_edit_careOf)).setVisibility(View.VISIBLE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_addline)).setVisibility(View.VISIBLE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_post_city)).setVisibility(View.VISIBLE);
            ((TextView)activity.findViewById(R.id.tv_act_edit_province_country)).setVisibility(View.VISIBLE);
            ((EditText)activity.findViewById(R.id.et_act_edit_careOf)).setVisibility(View.GONE);
            ((EditText)activity.findViewById(R.id.et_act_edit_addline)).setVisibility(View.GONE);
            ((EditText)activity.findViewById(R.id.et_act_edit_post_city)).setVisibility(View.GONE);
            ((EditText)activity.findViewById(R.id.et_act_edit_province_country)).setVisibility(View.GONE);
        }
    }
*/

    public List<UserAddress> getData() {
        return data;
    }

    public void setData(List<UserAddress> data) {
        this.data = data;
    }
}