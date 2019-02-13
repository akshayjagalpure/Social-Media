package com.social.media.web.controller;

import com.social.media.exception.ResourceNotFoundException;
import com.social.media.persistence.model.*;
import com.social.media.service.UniversityService;
import com.social.media.web.dto.UniversityDto;
import com.social.media.web.dto.UserRegistrationDto;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UniversityController {

	private static final Logger logger = LoggerFactory.getLogger(UniversityController.class);

	@Autowired
	private UniversityService universityService;

	@RequestMapping(value = "/university", method = RequestMethod.GET)
	public String getDashboardPage(Model model, @RequestParam(value = "tab", required = false) String tab,
								   @RequestParam(value = "start", required = false) String start,
								   @RequestParam(value = "end", required = false) String end) {
		Map<String, Object> attributes = this.universityService.getUniversity(tab, start, end);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		model.addAttribute("tab", tab);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("universityDto", new UniversityDto());
		return "forum/university";
	}

	@RequestMapping(value = "/university/syllabus", method = RequestMethod.GET)
	public String showSyllabusPage(Model model) {
		model.addAttribute("universityDto", new UniversityDto());
		return "forum/university-syllabus";
	}

	/*@RequestMapping(value = "/user/registration", method = RequestMethod.POST)

	public String registerNewUser(@Valid @ModelAttribute("userDto") UserRegistrationDto userDto,
								  BindingResult bindingResult, Model model, HttpServletRequest request) {
		*//*
		 * form validation, check username and email uniqueness
		 *//*
		this.userValidator.validate(userDto, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.info("BindingResult has errors >> " + bindingResult.getFieldError());
			return "forum/user-registration";
		}
		Map<String, Object> attributes = this.userService.registerUserAccount(userDto, request);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/user-registration-result";
	}*/

	@RequestMapping(value = "/university/syllabus", method = RequestMethod.POST)

	public String getUniversitySyllabus(@Valid @ModelAttribute("universityDto") UniversityDto universityDto,
								  BindingResult bindingResult, Model model, HttpServletRequest request) {
		/*
		 * form validation, check username and email uniqueness
		 */
		//this.userValidator.validate(universityDto, bindingResult);
		/*if (bindingResult.hasErrors()) {
			logger.info("BindingResult has errors >> " + bindingResult.getFieldError());
			return "forum/user-registration";
		}*/
		/*Map<String, Object> attributes = this.userService.registerUserAccount(universityDto, request);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}*/
		//model.addAllAttributes(attributes);
		//String registrationResult = affectedRow == 1 ? "success" : "failure";


		Map<String, Object> attributes = new HashMap<String, Object>();
		String registrationResult = "success";
		attributes.put("universityRegistrationResult", registrationResult);
		System.out.println("universityRegistrationResult");
		return "forum/university-syllabus-result";
	}

	/*@RequestMapping(value = "/university/syllabus", method = RequestMethod.POST)
	public String showSyllabus(@Valid @ModelAttribute("universityDto") UniversityDto universityDto,
								  BindingResult bindingResult, Model model, HttpServletRequest request) {


		Map<String, Object> attributes = this.universityService.registerUniversity(universityDto, request);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/university-syllabus-result";
	}*/

}