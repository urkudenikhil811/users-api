package io.users.models;

import java.util.ArrayList;

public class UserService {
	
	static ArrayList<User> list = new ArrayList<User>();
	
	//getAll	
	public static ArrayList<User> getAll(){
		return list;
	}
	
	//add
	public static void add(User newUser) {
		list.add(newUser);
	}
	
	//remove
	public static void remove(int id) {
		User userToRemove = getById(id);
		list.remove(userToRemove);
	}
	
	//getID
	public static User getById(int id) {
		User theUser = null;
		for(User everyUser : list) {
			if(everyUser.getUserId() == id) {
				theUser = everyUser;
			}
		}
		return theUser;
	}
}
