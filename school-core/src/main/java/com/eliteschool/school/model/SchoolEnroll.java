package com.eliteschool.school.model;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class SchoolEnroll {
	private static final Logger logger = LoggerFactory
			.getLogger(SchoolEnroll.class);
	
	@Id
	String schId;	
	String schName;
	String schAddress;
	Date schStartDate;
	String[] schCertifications;
	Date timeStamp;
	
	public SchoolEnroll() {		
		super();
		logger.info(" *** SchoolEnroll Empty Constructor *** ");
	}
	
	public SchoolEnroll(String schId) {
		super();
		logger.info(" *** SchoolEnroll schId Constructor *** ");
		this.schId = schId;
	}
	
	public SchoolEnroll(String schId, String schName, String schAddress,
			Date schStartDate, String[] schCertifications, Date timeStamp) {
		super();
		
		logger.info(" *** SchoolEnroll full Constructor *** ");
		
		this.schId = schId;
		this.schName = schName;
		this.schAddress = schAddress;
		this.schStartDate = schStartDate;
		this.schCertifications = schCertifications;
		this.timeStamp = timeStamp;
	}
	
	public String getSchId() {
		return schId;
	}
	public void setSchId(String schId) {
		this.schId = schId;
	}
	public String getSchName() {
		return schName;
	}
	public void setSchName(String schName) {
		this.schName = schName;
	}
	public String getSchAddress() {
		return schAddress;
	}
	public void setSchAddress(String schAddress) {
		this.schAddress = schAddress;
	}
	public Date getSchStartDate() {
		return schStartDate;
	}
	public void setSchStartDate(Date schStartDate) {
		this.schStartDate = schStartDate;
	}
	public String[] getSchCertifications() {
		return schCertifications;
	}
	public void setSchCertifications(String[] schCertifications) {
		this.schCertifications = schCertifications;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "School [schId=" + schId + ", schName=" + schName
				+ ", schAddress=" + schAddress + ", schStartDate="
				+ schStartDate + ", schCertifications="
				+ Arrays.toString(schCertifications) + ", timeStamp="
				+ timeStamp + "]";
	}
	
}
