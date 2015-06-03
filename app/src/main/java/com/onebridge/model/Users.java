package com.onebridge.model;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 4/25/2015.
 */
@ParseClassName("Users")
public class Users extends ParseObject implements Serializable{

    public int serialVersionId = 1;

    private String email;
    private String gender;
    private String fname;
    private String lname;
    private String username;
    private int userId;

    public static Users getUser(String id){
        Users user = new Users();
        try {
            List<Users> users = getQuery(id).find();

            if(users != null && users.size() > 0){
                Users po_user = users.get(0);
                setUserFields(po_user, po_user);
                user = po_user;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return user;
    }

    private static void setUserFields(Users user, ParseObject po){
        user.username = po.getString("userName");
        user.fname = po.getString("firstName");
        user.lname = po.getString("lastName");
        user.email = po.getString("email");
        user.gender = po.getString("gender");
        user.userId = po.getNumber("userId").intValue();
    }

    public static ParseQuery<Users> getQuery(String userId) {
        return ParseQuery.getQuery(Users.class).whereEqualTo("userName", userId);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        put("email",email);

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        put("gender",gender);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
        put("firstName",fname);

    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
        put("lastName",lname);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
