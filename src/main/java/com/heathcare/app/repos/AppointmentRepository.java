package com.heathcare.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.*;
import com.heathcare.app.pojos.Appointment;
@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, Long>{
	public List<Appointment> findByPatientId(Long patientId);
	
	public List<Appointment> findByDoctorId(Long doctorId);
	
	public List<Appointment> findByDoctorIdAndVisitDate(Long doctorId, Date visitDate);
	
	public Appointment findByAppointmentIdAndPatientId(Long appointmentId, Long patientId);
 
}
