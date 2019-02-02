package com.social.media.persistence.dao;

import com.social.media.persistence.model.University;
import com.social.media.persistence.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UniversityMapper {

	int save(University university);

	/*int update(User user);

	List<User> findAll();

	User findById(Long id);

	User findByUsername(String username);

	User findByEmail(String email);*/

}
