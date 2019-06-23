package com.heathcare.app.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heathcare.app.pojos.Doctor;
import com.heathcare.app.services.DoctorService;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping(path="/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService; 
	
	@PostMapping
	ResponseEntity<Doctor> create(@RequestBody Doctor doctor){
		Doctor doc=doctorService.create(doctor);
		if(doc==null)
			return new ResponseEntity<>(doc,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(doc,HttpStatus.OK);
	}
	
	
	@GetMapping(path="/{id}")
	ResponseEntity<Doctor> getDoctor(@PathVariable("id") Long id) {
		Doctor doc= doctorService.findById(id);
		if(doc==null)
			return new ResponseEntity<Doctor>(doc, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
		
	}
	
	@GetMapping
	ResponseEntity<List<Doctor>> getAll(){
		List<Doctor> docs=doctorService.findAll();
		return new ResponseEntity<>(docs, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Doctor> updateDoc(@RequestBody Doctor doc){
		Doctor doctor=doctorService.update(doc);
		if(doctor==null) {
			return new ResponseEntity<Doctor>(doctor,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	ResponseEntity<Doctor> deleteDoc(@PathVariable("id") Long id){
		Doctor doc;
		try {
			doc=doctorService.delete(id);
			if(doc==null)
				throw new NullPointerException("Doctor not found");
		}
		catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String, Object>> loginDoctor(@RequestBody Doctor doctor){
		HashMap<String, Object> map=new HashMap<>();
		Doctor obj=doctorService.findById(doctor.getId());
		try{if(obj==null){
		map.put("message", "Doctor not found.");
		map.put("status", false);
		map.put("data",doctor);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		}
		if(obj.getPassword().equals(doctor.getPassword()))
		{
			map.put("message", "Login successful.");
			map.put("status", true);
			map.put("data",obj);
			return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.OK);
		}
		}
		catch(Exception e) {}
		map.put("message", "Incorrect UserId or Password.");
		map.put("status", false);
		map.put("data",doctor);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		
	}
}
