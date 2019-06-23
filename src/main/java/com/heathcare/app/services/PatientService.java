package com.heathcare.app.services;

import java.util.List;

import com.heathcare.app.pojos.Patient;

public interface PatientService {
	
	Patient create(Patient user);

    Patient delete(int id);

    List<Patient> findAll();

    Patient findById(int id);

    Patient update(Patient user);

}
