package com.heathcare.app.services;

import java.util.List;

import com.heathcare.app.pojos.Doctor;

public interface DoctorService {
	
	Doctor create(Doctor doctor);
	
	Doctor delete(Long id);
	
	Doctor update(Doctor doctor);
	
	Doctor findById(Long id);
	
	List<Doctor> findAll();

}
