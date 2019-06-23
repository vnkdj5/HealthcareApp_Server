package com.heathcare.app.services;

import java.sql.Date;
import java.util.List;



import com.heathcare.app.pojos.Appointment;


public interface AppointmentService {

	Appointment create(Appointment appointment);
	
	Appointment delete(Long appointId);
	
	Appointment delete(Long appointId, Long patientId);
	
	Appointment update(Appointment appointment);
	
	Appointment findById(Long id);
	
	List<Appointment> findByPatientId(Long patientId);
	
	List<Appointment> findByDoctortId(Long doctorId);
	
	List<Appointment> findByDoctorIdAndVisitDate(Long doctorId, Date visitDate);

	
	List<Appointment> findAll();
	
	Appointment findByAppointmentIdAndPatientId(Long appointmentId, Long patientId);

}
