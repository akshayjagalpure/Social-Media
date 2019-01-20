package com.social.media.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.social.media.persistence.model.User;
import com.social.media.web.dto.UserRegistrationDto;
import com.social.media.web.dto.UserSettingsDto;

public interface UserService {

	int save(User user);

	User findById(Long id);

	User findByUsername(String username);

	User findByEmail(String email);

	User findAuthenticatedUser();

	Map<String, Object> getUserProfileAndPostsByUserIdByTabType(Long userId, String tabType);

	Map<String, Object> updateUserProfile(UserSettingsDto newUserSettingsForm);

	Map<String, Object> getUserSettingPage();

	Map<String, Object> registerUserAccount(UserRegistrationDto userDto, HttpServletRequest request);

	Map<String, Object> confirmUserRegistrationWithToken(String token);

}
