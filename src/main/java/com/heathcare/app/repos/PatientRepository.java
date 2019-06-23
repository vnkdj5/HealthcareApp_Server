package com.heathcare.app.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathcare.app.pojos.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	

}
