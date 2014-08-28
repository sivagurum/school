package com.eliteschool.school.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eliteschool.school.model.StudentEnroll;
public interface StudentEnrollRepository extends MongoRepository<StudentEnroll, String>{
	public List<StudentEnroll> findById();
}
