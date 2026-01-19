package com.yuvi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvi.model.RestUser;

@RestController
@RequestMapping("/user")
public class Controller {
	
	Map<String,RestUser>allusers = new HashMap<>();
	
   @GetMapping
	public Collection<RestUser> getMethod(){
		return allusers.values();
	} 
	
	
      @PostMapping
	public String postMethod(@RequestBody RestUser userdetails) {
		RestUser addvalue = new RestUser();
		addvalue.setUserId(userdetails.getUserId());
		addvalue.setname(userdetails.getname());
		addvalue.setemail(userdetails.getemail());
		allusers.put(userdetails.getUserId(), addvalue);
		allusers.put(userdetails.getname(), addvalue);
		allusers.put(userdetails.getemail(), addvalue);
		return "User Added.";
	} 
	
      @PutMapping(path="/{userId}")
	public String putMethod(@PathVariable String userId,@RequestBody RestUser userdetails){
    	  
    	  if(allusers.containsKey(userId)) {
    		  RestUser addvalue = new RestUser();
    		  addvalue.setUserId(userdetails.getUserId());
    			addvalue.setname(userdetails.getname());
    			addvalue.setemail(userdetails.getemail());
    			allusers.put(userId, addvalue);
    			return "user details updadted..";
    	  }else {
    	  
		return "..User Id not found!. ";
    	  }
	}
	
     @DeleteMapping(path="/{userId}")
	public String deleteMethod(@PathVariable String userId) {
    	 if(allusers.containsKey(userId)) {
    		 allusers.remove(userId);
    		 return "user Deleted !.";
    		  
    	 }else {
    		 return "user not found!.";
    	 }
    	 
	}
}
