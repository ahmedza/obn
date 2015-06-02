package com.onebridge.manager;

import java.util.List;

import com.onebridge.model.ProductCategory;
import com.onebridge.model.UserAddress;
import com.onebridge.model.Users;
import com.parse.ParseException;
import com.parse.ParseQuery;

public class DataManager {

	private static DataManager dataManager= null;
	
	protected List<ProductCategory> fetchProductCategories(){
		/*List<MenuItem> menuItems = new  ArrayList<MenuItem>();*/
		
		ParseQuery<ProductCategory> categories= ProductCategory.getQuery();
				
		
		try {
			return categories.find();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
	}

    public Users getUser(String id){
        if(id == null || id.equals("")){
            id = "newtechsupplies";
        }
        return Users.getUser(id);
    }

    public UserAddress getUserAddress(String userId){

        return UserAddress.getUserAddress(userId);
    }

    public List<UserAddress> getUserAddresses(String userId){

        return UserAddress.getUserAddresses(userId);
    }

	protected static DataManager getDataManager(){
		
		if(dataManager == null){
			dataManager = new DataManager();
		}
		
		return dataManager;
	}
}
