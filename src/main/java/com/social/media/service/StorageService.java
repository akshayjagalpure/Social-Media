package com.social.media.service;

import org.springframework.web.multipart.MultipartFile;

import com.social.media.persistence.model.User;

public interface StorageService {

	void init();

	User store(MultipartFile file, String path);

	void deleteAll();

}