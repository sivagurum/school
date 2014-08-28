package com.eliteschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.eliteschool.school.model.StudentEnroll;
import com.eliteschool.school.service.StudentEnrollService;


@Controller
@RequestMapping("/studentEnroll")
public class StudentEnrollController {

	@Autowired
	private StudentEnrollService studentEnrollService;
	
	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public String getPlainRequest(ModelMap model) {
		return "redirect:/studentEnroll/view";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String getStudentList(ModelMap model){
		
		StudentEnroll studentEnroll = new StudentEnroll();
		model.addAttribute("studentEnroll",studentEnroll);
		//model.addAttribute("studentList",studentEnrollService.listStudentEnroll());
		return "StudentEnrollForm";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String createStudentDetail(@ModelAttribute("studentEnroll") StudentEnroll studentEnroll,ModelMap model){
		if(StringUtils.hasText(studentEnroll.getId())){
			studentEnrollService.addStudentEnroll(studentEnroll);
		}
		
		return "StudentEnrollSuccess";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public View deleteStudentDetail(@ModelAttribute StudentEnroll studentEnroll,ModelMap map){
		studentEnrollService.deleteStudentEnroll(studentEnroll);
		return new RedirectView("/school-web/studentEnroll");
	}
}
