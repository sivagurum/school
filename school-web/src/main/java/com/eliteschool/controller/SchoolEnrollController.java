package com.eliteschool.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.eliteschool.school.validator.SchoolEnrollValidator;
import com.eliteschool.school.model.SchoolEnroll;

//@Controller
//@RequestMapping("/schoolEnroll")
public class SchoolEnrollController {
	/*private static final Logger logger =
			LoggerFactory.getLogger(SchoolEnrollController.class);
	
	SchoolEnrollValidator schoolEnrollValidator;
	
	@Autowired
	public SchoolEnrollController(SchoolEnrollValidator schoolEnrollValidator) {
		logger.info(" ** SchoolEnrollController ** ");		
		this.schoolEnrollValidator = schoolEnrollValidator;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
			@ModelAttribute("schoolEnroll") SchoolEnroll schoolEnroll,
			BindingResult bindResult, SessionStatus sessionStatus) {
		
		logger.info(" ** processSubmit ** ");		
		schoolEnrollValidator.validate(schoolEnroll, bindResult);
		if (bindResult.hasErrors()) {
			return "SchoolEnrollForm";
		} else {
			sessionStatus.setComplete();
			return "SchoolEnrollSuccess";
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		// Initial Value Set Here
		logger.info(" ** initForm ** ");		
		SchoolEnroll schEnroll = new SchoolEnroll();
		schEnroll.setSchCertifications(new String[] { "CBSE Certification" });
		schEnroll.setSchStartDate(new Date());
		schEnroll.setTimeStamp(new Date());

		model.addAttribute("schoolEnroll", schEnroll);

		return "SchoolEnrollForm";
	}

	@ModelAttribute("schCertificationList")
	public Map<String, String> populateSchCertifications() {
		logger.info(" ** populateSchCertifications ** ");
		Map<String, String> map = new HashMap<String, String>();
		map.put("NASP", "NASP Certification");
		map.put("CBT", "CBT Certification");
		map.put("CBSE", "CBSE Certification");
		return map;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.info(" ** initBinder ** ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}*/
}
