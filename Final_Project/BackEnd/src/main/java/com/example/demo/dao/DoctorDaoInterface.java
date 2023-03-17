package com.example.demo.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Doctor;

@Repository
public interface DoctorDaoInterface extends JpaRepository<Doctor, Long> 
{
	Doctor findByEmailAndIsVerified(String string,int verified);	
	
	List<Doctor> findAllByDoctorSpecializationAndIsVerified(String doctorSpecialization,int verified);
	
	Doctor findByEmailAndPasswordAndIsVerified(String email, String password,int verified);
	
	Doctor findByEmailAndDoctorContactAndIsVerified(String email, long l,int verified);
		
	List<Doctor>findAllByIsVerified(int verified);
	
	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("update Doctor d set d.isVerified = 2 where d.doctorId = :id")
	int deletedoctor(@Param("id") long id );
	
	@Transactional
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("update Doctor d set d.isVerified = 1 where d.doctorId = :id")
	int doctorverified(@Param("id") long id );
}
