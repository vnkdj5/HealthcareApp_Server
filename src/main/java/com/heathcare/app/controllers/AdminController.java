package com.heathcare.app.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heathcare.app.pojos.Admin;
import com.heathcare.app.pojos.Patient;
import com.heathcare.app.services.AdminService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
@RestController
@RequestMapping(path="/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String, Object>> loginpatient(@RequestBody Admin admin){
		HashMap<String, Object> map=new HashMap<>();
		Admin obj=adminService.findById(admin.getId());
		try {
		if(obj==null){
		map.put("message", "User not found.");
		map.put("status", false);
		map.put("data",admin);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		}
		if(obj.getPassword().equals(admin.getPassword()))
		{
			map.put("message", "Login successful.");
			map.put("status", true);
			map.put("data",obj);
			return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.OK);
		}
		}
		catch(NullPointerException e) {}
		map.put("message", "Incorrect UserId or Password.");
		map.put("status", false);
		map.put("data",admin);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		
	}
}
