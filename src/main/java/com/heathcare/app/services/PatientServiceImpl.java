package com.heathcare.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heathcare.app.pojos.Patient;
import com.heathcare.app.repos.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository repository;

	@Override
	public Patient create(Patient patient) {
		// TODO Auto-generated method stub
		return repository.save(patient);
	}

	@Override
	public Patient delete(int id) {
		Patient patient=findById(id);
		if(patient!=null)
		{
			repository.delete(patient);
		}
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		return repository.findAll();
	}

	@Override
	public Patient findById(int id) {
		Optional<Patient> patient=repository.findById(id);
		
		if(patient.isPresent()) {
			return patient.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Patient update(Patient patient) {
		return repository.save(patient);
	}
}
