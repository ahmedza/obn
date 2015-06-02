package com.onebridge.model;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4/25/2015.
 */
@ParseClassName("UserAddress")
public class UserAddress extends ParseObject{

    private Long addressId;
    private String addLine1;
    private String addLine2;
    private String postalAdd;
    private Long city;
    private Long province;
    private String longitude;
    private String latitude;


    private Long countryCode;
    private String attentionTo;

    public static UserAddress getUserAddress(String userId){
        UserAddress add = new UserAddress();
        ParseQuery<UserAddress> query = ParseQuery.getQuery(UserAddress.class).whereEqualTo("userId",1);
        List<UserAddress> userAdds = new ArrayList<UserAddress>();
        try {
            userAdds = query.find();
            if(userAdds != null && userAdds.size() > 0){
                setAddressFields(userAdds.get(0), userAdds.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userAdds.get(0);
    }

    public static List<UserAddress> getUserAddresses(String userId){

        ParseQuery<UserAddress> query = ParseQuery.getQuery(UserAddress.class).whereEqualTo("userId",1);
        try {
            List<UserAddress> userAdds = query.find();
            if(userAdds != null && userAdds.size() > 0){
                for (UserAddress address :userAdds) {
                    setAddressFields(address);
                }
//                setAddressFields(userAdds.get(0));
            }
            return userAdds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void  setAddressFields(UserAddress add, ParseObject po){
        add.addLine1 = po.getString("addressLine1");
        add.addLine2 = po.getString("addressLine2");
        add.city = po.getLong("cityCode");
        add.countryCode = po.getLong("countryCode");
        add.postalAdd = po.getString("postalCode");
        add.attentionTo = po.getString("attentionTo");
        add.setAddressId(add.getLong("addressId"));
        add.setProvince(add.getLong("stateProvinceCode"));
    }

    private static void  setAddressFields(UserAddress add){
        add.addLine1 = add.getString("addressLine1");
        add.addLine2 = add.getString("addressLine2");
        add.city = add.getLong("cityCode");
        add.countryCode = add.getLong("countryCode");
        add.postalAdd = add.getString("postalCode");
        add.attentionTo = add.getString("attentionTo");
        add.setAddressId(add.getLong("addressId"));
        add.setProvince(add.getLong("stateProvinceCode"));
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
        this.put("addressLine1", addLine1);
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
//        this.remove("addressLine2");
        this.put("addressLine2", addLine2);
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
        //this.remove("postalCode");
        this.put("postalCode", postalAdd);
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
//        this.remove("cityCode");
        this.put("cityCode", city);
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
        put("stateProvinceCode", province);
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
        /*this.add("latitude",latitude);*/
    }

    public String getAttentionTo() {
        return attentionTo;
    }

    public void setAttentionTo(String attentionTo) {
        this.attentionTo=attentionTo;
        this.put("attentionTo", attentionTo);

    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }


    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getAddressId() {
        return addressId;
    }
}
