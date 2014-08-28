package com.eliteschool.school.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.eliteschool.school.model.StudentEnroll;

//http://mehtagautam.blogspot.in/2012/09/step-by-step-spring-mongodb-integration.html

@Service
public class StudentEnrollService {
	private static final Logger logger = LoggerFactory
			.getLogger(StudentEnrollService.class);
	
	@Autowired
	private StudentEnrollRepository repository;
	
	public void addStudentEnroll(StudentEnroll studentEnroll) {
		
		logger.info(" *** StudentEnroll addSchool  *** ");
		
		repository.save(studentEnroll);		
	}
	
	public List<StudentEnroll> listStudentEnroll(){
		
		logger.info(" *** StudentEnroll listStudentEnroll  *** ");
		
		return repository.findAll();
	}
	
	public void deleteStudentEnroll(StudentEnroll studentEnroll){
		repository.delete(studentEnroll.getId());
	}
}
