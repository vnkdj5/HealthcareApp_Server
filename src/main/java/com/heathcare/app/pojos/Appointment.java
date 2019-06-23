package com.heathcare.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Appointment {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long appointmentId;
	
	@Column
	Long patientId;
	
	@Column
	Date visitDate;
	
	@Column
	String timeslot;
	
	@Column //Drop Down menu
	String subject;
	@Column //Description if any
	String description;
	
	@Column 
	Long doctorId;

	/**
	 * @param patientId
	 * @param visitDate
	 * @param timeslot
	 * @param subject
	 * @param description
	 * @param doctorId
	 */
	public Appointment(Long patientId, Date visitDate, String timeslot, String subject, String description,
			Long doctorId) {
		super();
		this.patientId = patientId;
		this.visitDate = visitDate;
		this.timeslot = timeslot;
		this.subject = subject;
		this.description = description;
		this.doctorId = doctorId;
	}

	public Appointment(Long appointmentId, Long patientId, Date visitDate, String timeslot, String subject,
			String description, Long doctorId) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.visitDate = visitDate;
		this.timeslot = timeslot;
		this.subject = subject;
		this.description = description;
		this.doctorId = doctorId;
	}
}
