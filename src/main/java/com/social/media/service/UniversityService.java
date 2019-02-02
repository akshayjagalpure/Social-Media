package com.social.media.service;

import com.social.media.persistence.model.Post;
import com.social.media.persistence.model.University;
import com.social.media.web.dto.PostDto;
import com.social.media.web.dto.UniversityDto;
import com.social.media.web.dto.UserRegistrationDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UniversityService {

	int save(University university);
	Map<String, Object> registerUniversity(UniversityDto universityDto, HttpServletRequest request);

}
