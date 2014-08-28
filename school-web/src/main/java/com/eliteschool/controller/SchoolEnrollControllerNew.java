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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.eliteschool.school.service.SchoolEnrollService;
import com.eliteschool.school.validator.SchoolEnrollValidator;
import com.eliteschool.school.model.SchoolEnroll;

@Controller
@RequestMapping("/schoolEnroll")
public class SchoolEnrollControllerNew {
	private static final Logger logger = LoggerFactory
			.getLogger(SchoolEnrollControllerNew.class);

	SchoolEnrollValidator schoolEnrollValidator;

	@Autowired
	private SchoolEnrollService schoolEnrollService;

	@Autowired
	public SchoolEnrollControllerNew(SchoolEnrollValidator schoolEnrollValidator) {
		logger.info(" ** SchoolEnrollController ** ");
		this.schoolEnrollValidator = schoolEnrollValidator;
	}
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String getPlainRequest(ModelMap model) {
		return "redirect:/schoolEnroll/save";
	}

	@RequestMapping(value = {"/save"}, method = RequestMethod.GET)
	public String getSchoolList(ModelMap model) {
		// Initial Value Set Here
		logger.info(" ** initForm ** ");
		SchoolEnroll schEnroll = new SchoolEnroll();
		schEnroll.setSchCertifications(new String[] { "CBSE Certification" });
		schEnroll.setSchStartDate(new Date());
		schEnroll.setTimeStamp(new Date());
		model.addAttribute("schoolEnroll", schEnroll);

		model.addAttribute("schoolEnrollList", schoolEnrollService.listSchool());
		return "SchoolEnrollFormNew";
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView createSchool(
			@ModelAttribute("schoolEnroll") SchoolEnroll schoolEnroll,
			BindingResult bindResult, ModelMap model,
			SessionStatus sessionStatus) {		
		
		logger.info(" ** createSchool ** ");
		
		schoolEnrollValidator.validate(schoolEnroll, bindResult);		
		
		if (bindResult.hasErrors()) {			
			logger.info(" *** bind result error came *** ");
			model.addAttribute("schoolEnrollList", schoolEnrollService.listSchool());
			return new ModelAndView("SchoolEnrollFormNew");
		} else {
			if (StringUtils.hasText(schoolEnroll.getSchId())) {
				logger.info(" *** updateSchool *** ");
				schoolEnrollService.saveSchool(schoolEnroll);
			} else {
				logger.info(" *** addSchool *** ");
				schoolEnrollService.addSchool(schoolEnroll);
			}			
			sessionStatus.setComplete();			
			return new ModelAndView("redirect:/schoolEnroll/save");			
		}
		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSchool(@ModelAttribute SchoolEnroll schoolEnroll,
			ModelMap model) {
		
		logger.info(" ** deleteSchool ** ");
		
		schoolEnrollService.deleteSchool(schoolEnroll);
		//return new RedirectView("/school-web/schoolEnroll/save");
		return "redirect:/schoolEnroll/save";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateSchool(@ModelAttribute("schoolEnroll") SchoolEnroll schoolEnroll,ModelMap model){
		
		logger.info(" ** updateSchool ** ");
		
		SchoolEnroll schEnroll = schoolEnrollService.getSchoolById(schoolEnroll);	
		
		model.addAttribute("schoolEnroll", schEnroll);

		model.addAttribute("schoolEnrollList", schoolEnrollService.listSchool());
		
		return "SchoolEnrollFormNew";
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
	}
}
