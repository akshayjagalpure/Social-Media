package com.social.media.service.impl;

import com.social.media.event.OnRegistrationCompleteEvent;
import com.social.media.persistence.dao.*;
import com.social.media.persistence.model.*;
import com.social.media.service.StorageService;
import com.social.media.service.UniversityService;
import com.social.media.service.UserService;
import com.social.media.web.dto.UniversityDto;
import com.social.media.web.dto.UserRegistrationDto;
import com.social.media.web.dto.UserSettingsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service("universityService")
public class UniversityServiceImpl implements UniversityService {

	private static final Logger logger = LoggerFactory.getLogger(UniversityServiceImpl.class);

	@Autowired
	private UniversityMapper universityMapper;

	@Override
	public Map<String, Object> getUniversity(String tab, String startDate, String endDate) {
		String activeTab = tab == null ? "stats" : tab; // default tab
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("activeTab", activeTab);
		//attributes.put("newPostForm", new PostDto());
		switch (activeTab) {
			case "syllabus":
				attributes.put("syllabus", null);
				break;
			/*case "posts":
				List<Post> posts = this.postMapper.findPostsBetweenRange(startDate + " 00:00:00",
						endDate + " 23:59:59");
				attributes.put("posts", posts);
				break;
			case "users":
				List<User> users = this.userMapper.findAll();
				attributes.put("users", users);
				break;
			case "categories":
				List<Category> categories = this.categoryMapper.findAll();
				attributes.put("categories", categories);
				break;*/
		}
		return attributes;
	}

	@Override
	public int save(University university) {
		//university.setPassword(bCryptPasswordEncoder.encode(university.getPassword()));
		return universityMapper.save(university);
	}

	@Override
	public Map<String, Object> registerUniversity(UniversityDto universityDto, HttpServletRequest request) {
		Map<String, Object> attributes = new HashMap<>();

		// save newly registered user
		University university = new University();
		//university.setTitle(universityDto.getTitle());
		// save new user and get number of affected row
		int affectedRow = universityMapper.save(university);


		// populate attributes
		String registrationResult = affectedRow == 1 ? "success" : "failure";
		attributes.put("universityRegistrationResult", registrationResult);
		return attributes;
	}

}
