package com.eliteschool.school.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.eliteschool.school.model.SchoolEnroll;
import com.eliteschool.util.Commons;

@Repository
public class SchoolEnrollService{
	private static final Logger logger = LoggerFactory
			.getLogger(SchoolEnrollService.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;	
	
	public void addSchool(SchoolEnroll schoolEnroll) {
		
		logger.info(" *** SchoolEnrollService addSchool  *** ");
		
		if(!mongoTemplate.collectionExists(SchoolEnroll.class)){
			mongoTemplate.createCollection(SchoolEnroll.class);
		}
		mongoTemplate.insert(schoolEnroll);
	}

	public List<SchoolEnroll> listSchool() {
		
		logger.info(" *** SchoolEnrollService listSchool  *** ");
		
		return mongoTemplate.findAll(SchoolEnroll.class, Commons.SCHOOL_ENROLL_COLLECTION_NAME);
	}

	public void saveSchool(SchoolEnroll schoolEnroll) {
		
		logger.info(" *** SchoolEnrollService saveSchool  *** ");
		
		mongoTemplate.save(schoolEnroll, Commons.SCHOOL_ENROLL_COLLECTION_NAME);		
	}

	public void deleteSchool(SchoolEnroll schoolEnroll) {		
		logger.info(" *** SchoolEnrollService deleteSchool  *** ");
		
		mongoTemplate.remove(schoolEnroll, Commons.SCHOOL_ENROLL_COLLECTION_NAME);		
	}
	
	
	public SchoolEnroll getSchoolById(SchoolEnroll schoolEnroll){
		
		logger.info(" *** SchoolEnrollService getSchoolById  *** "+schoolEnroll.getSchId());
		
		SchoolEnroll schEnrol = mongoTemplate.findById(schoolEnroll.getSchId(), SchoolEnroll.class, Commons.SCHOOL_ENROLL_COLLECTION_NAME);		
		
		/*
		Query query = new Query(Criteria.where("_id").is(schoolEnroll.getSchId()));
		logger.info(" ** "+mongoTemplate.findOne(query, SchoolEnroll.class)+" ** ");
		SchoolEnroll schEnrol = mongoTemplate.findOne(query, SchoolEnroll.class);
		*/		
		logger.info(" **** "+schEnrol+" **** ");
		return schEnrol;
	}

}
