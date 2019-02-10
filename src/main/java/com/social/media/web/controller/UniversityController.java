package com.social.media.web.controller;

import com.social.media.exception.BadRequestException;
import com.social.media.exception.ResourceNotFoundException;
import com.social.media.persistence.model.Comment;
import com.social.media.persistence.model.Post;
import com.social.media.persistence.model.University;
import com.social.media.service.CategoryService;
import com.social.media.service.CommentService;
import com.social.media.service.PostService;
import com.social.media.service.UniversityService;
import com.social.media.util.NewPostFormValidator;
import com.social.media.web.dto.CommentDto;
import com.social.media.web.dto.PostDto;
import com.social.media.web.dto.UniversityDto;
import com.social.media.web.dto.UserRegistrationDto;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UniversityController {

	private static final Logger logger = LoggerFactory.getLogger(UniversityController.class);

	@Autowired
	private UniversityService universityService;

	@RequestMapping(value = "/university/Uni_BY", method = RequestMethod.GET)
	public String showSyllabus(Model model) {
		//model.addAttribute("universityDto", new UniversityDto());
		return "forum/Uni_BY";
	}

	@RequestMapping(value = "/university/registration", method = RequestMethod.GET)
	public String showRegistrationPage(Model model) {
		model.addAttribute("universityDto", new UniversityDto());
		return "forum/university-registration";
	}

	@RequestMapping(value = "/university/registration", method = RequestMethod.POST)
	public String registerNewUser(@Valid @ModelAttribute("universityDto") UniversityDto universityDto,
								  BindingResult bindingResult, Model model, HttpServletRequest request) {


		Map<String, Object> attributes = this.universityService.registerUniversity(universityDto, request);
		if (null == attributes) {
			throw new ResourceNotFoundException("attributes not found.");
		}
		model.addAllAttributes(attributes);
		return "forum/university-registration-result";
	}

}