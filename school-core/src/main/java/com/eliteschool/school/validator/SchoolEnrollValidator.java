package com.eliteschool.school.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.eliteschool.school.model.SchoolEnroll;

@Component
public class SchoolEnrollValidator implements Validator{
	private static final Logger logger = LoggerFactory
			.getLogger(SchoolEnrollValidator.class);
	
	public boolean supports(Class<?> clazz) {		
		return SchoolEnroll.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		logger.info(" *** SchoolEnrollValidator validate *** ");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schId", "required.schId","Field Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schName", "required.schName","Field Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "schAddress", "required.schAddress","Field Name is required");
	}
	
}
