package com.heathcare.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heathcare.app.pojos.Doctor;
import com.heathcare.app.repos.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository repository;

	@Override
	public Doctor create(Doctor doctor) {
		return repository.save(doctor);
	}

	@Override
	public Doctor delete(Long id) {
		Doctor doctor=findById(id);
		if(doctor!=null)
			repository.delete(doctor);
		return doctor;
	}

	@Override
	public Doctor update(Doctor doctor) {
		
		return repository.save(doctor);
	}

	@Override
	public Doctor findById(Long id) {
		Optional<Doctor> doctor=repository.findById(id);
		if(doctor.isPresent())
			return doctor.get();
		return null;
	}

	@Override
	public List<Doctor> findAll() {
		return repository.findAll();
	}
	

}
