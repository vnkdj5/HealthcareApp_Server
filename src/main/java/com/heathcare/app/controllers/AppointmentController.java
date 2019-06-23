package com.heathcare.app.controllers;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heathcare.app.pojos.Appointment;
import com.heathcare.app.services.AppointmentService;;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping(path="/appointment")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@PostMapping
	ResponseEntity<Appointment> create(@RequestBody Appointment appointment){
		System.out.println("creating appointment "+appointment.toString());
		Appointment appoint=appointmentService.create(appointment);
		if(appoint==null)
			return new ResponseEntity<>(appoint,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(appoint,HttpStatus.OK);
	}
	
	//Get all appointments of particular patient
	@GetMapping("/p")
	ResponseEntity<List<Appointment>> getPatinetAppointments(@RequestParam("patientId") Long id) {
		List<Appointment> aList= appointmentService.findByPatientId(id);
		if(aList.isEmpty())
			return new ResponseEntity<>(aList, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(aList, HttpStatus.OK);
		
	}
	
	//Get all appointments of particular doctor
		@GetMapping("/d")
		ResponseEntity<List<Appointment>> getDoctorAppointments(@RequestParam("doctorId") Long id) {
			List<Appointment> aList=null;
			//System.out.println("Visit Date"+date);
			try {
				aList= appointmentService.findByDoctortId(id);
			
			
			}
			catch(NullPointerException ex) {
				
			}
			if(aList.isEmpty())
				return new ResponseEntity<>(aList, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(aList, HttpStatus.OK);
			
		}
		//get appointment by date and doctorid
		@GetMapping("/doc")
		ResponseEntity<List<Appointment>> getDoctorAppointmentss(@RequestParam("doctorId") Long id, @RequestParam("visitDate") Date date) {
			List<Appointment> aList=null;
			//System.out.println("Visit Date"+date);
			try {
			
				aList=appointmentService.findByDoctorIdAndVisitDate(id, date);
			
			}
			catch(NullPointerException ex) {
				
			}
			if(aList.isEmpty())
				return new ResponseEntity<>(aList, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(aList, HttpStatus.OK);
			
		}
	//Get appointment details by appointment Id
	@GetMapping(path="/{id}")
	ResponseEntity<Appointment> getAppointment(@PathVariable("id") Long id) {
		Appointment appoint= appointmentService.findById(id);
		if(appoint==null)
			return new ResponseEntity<Appointment>(appoint, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Appointment>(appoint, HttpStatus.OK);
		
	}
	
	@GetMapping
	ResponseEntity<List<Appointment>> getAll(){
		List<Appointment> appoints=appointmentService.findAll();
		System.out.println("Appointents"+ appoints.toArray()[0]);
		return new ResponseEntity<>(appoints, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Appointment> updateDoc(@RequestBody Appointment appointment){
		Appointment appoint=appointmentService.update(appointment);
		if(appoint==null) {
			return new ResponseEntity<Appointment>(appoint,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Appointment>(appoint,HttpStatus.OK);
	}
	
	@DeleteMapping(path="{patientId}/{id}")
	ResponseEntity<Appointment> deleteDoc(@PathVariable("id") Long id,@PathVariable("patientId") Long patientId){
		Appointment appoint;
		try {
			appoint=appointmentService.delete(id,patientId);
			if(appoint==null)
				throw new NullPointerException("Appointment not found.");
		}
		catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Appointment>(appoint, HttpStatus.OK);
	}
}
