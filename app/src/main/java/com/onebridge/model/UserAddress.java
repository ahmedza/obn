package com.onebridge.model;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by user on 4/25/2015.
 */
@ParseClassName("UserAddress")
public class UserAddress extends ParseObject{

    private String addLine1;
    private String addLine2;
    private String postalAdd;
    private String city;
    private String province;
    private String longitude;
    private String latitude;
    private String countryCode;
    private String attentionTo;

    public static UserAddress getUserAddress(String userId){
        UserAddress add = new UserAddress();
        ParseQuery<UserAddress> query = ParseQuery.getQuery(UserAddress.class).whereEqualTo("userId",1);
        try {
            List<UserAddress> userAdds = query.find();
            if(userAdds != null && userAdds.size() > 0){
                setAddressFields(add, userAdds.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return add;
    }

    private static void  setAddressFields(UserAddress add, ParseObject po){
        add.addLine1 = po.getString("addressLine1");
        add.addLine2 = po.getString("addressLine2");
        add.city = po.getString("cityCode");
        add.countryCode = po.getString("countryCode");
        add.postalAdd = po.getString("postalCode");
        add.attentionTo = po.getString("attentionTo");
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAttentionTo() {
        return attentionTo;
    }

    public void setAttentionTo(String attentionTo) {
        this.attentionTo = attentionTo;
    }
}
