package com.social.media.persistence.dao;

import org.apache.ibatis.annotations.Mapper;

import com.social.media.persistence.model.VerificationToken;

@Mapper
public interface VerificationTokenMapper {

	int save(VerificationToken token);

	VerificationToken findByToken(String token);

	VerificationToken findByUserId(Long userId);

}