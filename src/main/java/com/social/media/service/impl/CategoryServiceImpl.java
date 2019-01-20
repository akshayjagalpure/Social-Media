package com.social.media.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.media.constant.PageMessage;
import com.social.media.persistence.dao.CategoryMapper;
import com.social.media.persistence.model.Category;
import com.social.media.service.CategoryService;
import com.social.media.web.dto.PostDto;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int save(Category category) {
		return this.categoryMapper.save(category);
	}

	@Override
	public Map<String, Object> getNewPostPageWithCategoryName(String categoryName) {
		Map<String, Object> attributes = new HashMap<>();
		Category category = this.categoryMapper.findByName(categoryName);
		attributes.put("title", PageMessage.MESSAGE_NEW_POST_EN);
		PostDto newPostForm = new PostDto();
		newPostForm.setCategory(category.getName());
		attributes.put("postDto", newPostForm);
		attributes.put("isQuickNewPost", false);
		return attributes;
	}

	@Override
	public Map<String, Object> getNewPostPageWithCategorySelect() {
		List<Category> categories = this.categoryMapper.findAll();
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("title", PageMessage.MESSAGE_NEW_POST_EN);
		attributes.put("categories", categories);
		attributes.put("postDto", new PostDto());
		attributes.put("isQuickNewPost", true);
		return attributes;
	}

	@Override
	public List<Category> findAll() {
		return this.categoryMapper.findAll();
	}

}
