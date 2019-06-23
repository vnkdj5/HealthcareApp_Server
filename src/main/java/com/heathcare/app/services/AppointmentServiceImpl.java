package com.heathcare.app.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heathcare.app.pojos.Appointment;
import com.heathcare.app.repos.AppointmentRepository;
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository repository;
	@Override
	public Appointment create(Appointment appointment) {
		return repository.save(appointment);
	}

	@Override
	public Appointment delete(Long appointId) {
		Appointment appointment=findById(appointId);
		if(appointment!=null)
			repository.delete(appointment);
		return appointment;
	}

	@Override
	public Appointment update(Appointment appointment) {
		return repository.save(appointment);
	}

	@Override
	public Appointment findById(Long id) {
		Optional<Appointment> docs=repository.findById(id);
		if(docs.isPresent())
			return docs.get();
		return null;
	}

	@Override
	public List<Appointment> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Appointment> findByPatientId(Long patientId) {
		return repository.findByPatientId(patientId);
		
	}

	@Override
	public List<Appointment> findByDoctortId(Long doctorId) {
		return repository.findByDoctorId(doctorId);
	}

	@Override
	public Appointment findByAppointmentIdAndPatientId(Long appointmentId, Long patientId) {
		return repository.findByAppointmentIdAndPatientId(appointmentId, patientId);
	}

	@Override
	public Appointment delete(Long appointId, Long patientId) {
		Appointment appointment=findByAppointmentIdAndPatientId(appointId, patientId);
		if(appointment!=null)
			repository.delete(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> findByDoctorIdAndVisitDate(Long doctorId, Date visitDate) {
		return repository.findByDoctorIdAndVisitDate(doctorId, visitDate);
	}

}
