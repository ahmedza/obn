package com.onebridge.manager;

import com.onebridge.model.UserAddress;
import com.onebridge.model.Users;

import java.util.List;

/**
 * Created by user on 4/25/2015.
 */
public class AccountManager extends RootManager {

    private static AccountManager accManager = null;

    public Users getUser(String userName){
        Users user = getDataManager().getUser(userName);

        return user;
    }

    public UserAddress getAddress(String userId){
        return  getDataManager().getUserAddress(userId);
    }

    public List<UserAddress> getAddresses(String userId){
        return  getDataManager().getUserAddresses(userId);
    }

    public static AccountManager getAccountManager(){
        if(accManager == null){
            accManager = new AccountManager();
        }
        return accManager;
    }



}
