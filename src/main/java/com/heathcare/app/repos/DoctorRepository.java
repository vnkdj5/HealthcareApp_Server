package com.heathcare.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathcare.app.pojos.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
