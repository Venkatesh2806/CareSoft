package com.example.demo.dao;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Appointment;


@Repository
public interface AppointmentDAOInterface extends JpaRepository<Appointment, Long> {

	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("select a from Appointment a where a.appointDate = :DATE and a.doctor.doctorId = :ID")
	List<Appointment> findByAppointDateAndDoctorId(@Param("DATE") Date appointDate ,@Param("ID") long id);
	
	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("select a from Appointment a where a.patientemail = :email and a.patient.isVerified = true")
	List<Appointment> findAllByPatientemail(@Param("email") String email);
	
	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("select a from Appointment a where a.doctoremail = :email and a.doctor.isVerified = 1 and a.status != 2")
	List<Appointment> findAllByDoctorAppointmentHistory(@Param("email") String email);
	
	List<Appointment> findAllByDoctoremailAndStatus(String email,int status);
	
	List<Appointment> findAllByDoctoremail(String email);
	
	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("update Appointment a set a.status = :Status where a.appointId = :id")
	int Appointmentstatus(@Param("id") long id,@Param("Status") int Status );
		
}
