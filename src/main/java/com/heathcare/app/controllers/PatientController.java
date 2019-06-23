package com.heathcare.app.controllers;

import java.util.HashMap;
import java.util.List;

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

import com.heathcare.app.pojos.Patient;
import com.heathcare.app.services.PatientService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) 
@RestController
@RequestMapping({"/patient"})
public class PatientController {
	@Autowired PatientService patientService;
	
	@PostMapping
	public Patient create(@RequestBody Patient patient) {
		return patientService.create(patient);
	}
	
	@GetMapping
	public List<Patient> findAll() {
		
		List<Patient> list=patientService.findAll();
		System.out.println(list.get(0).toString());
		return list; 
	}
	
	@GetMapping(path={"/{id}"})
	public Patient find(@PathVariable("id") int id) {
		return patientService.findById(id);
	}
	
	@PutMapping
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.update(patient);
	}
	
	@DeleteMapping(path= {"/{id}"})
	public Patient deletePatient(@PathVariable("id") int id) {
		
		return patientService.delete(id);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String, Object>> loginpatient(@RequestBody Patient patient){
		HashMap<String, Object> map=new HashMap<>();
		Patient obj=patientService.findById(patient.getId());
		try {
		if(obj==null){
		map.put("message", "User not found.");
		map.put("status", false);
		map.put("data",patient);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		}
		if(obj.getPassword().equals(patient.getPassword()))
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
		map.put("data",patient);
		return new ResponseEntity<HashMap<String,Object>>(map, HttpStatus.FORBIDDEN);
		
	}
	
}
