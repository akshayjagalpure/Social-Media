package com.social.media.service;

import java.util.Map;

import com.social.media.persistence.model.Post;
import com.social.media.web.dto.PostDto;

public interface PostService {

	void save(Post post);

	void delete(Long postId);

	void update(Post post);

	Post findById(Long id);

	Post createNewPost(PostDto newPostForm);

	int deletePostAndComments(Long postId);

	Map<String, Object> findPosts();

	Map<String, Object> findPostsByPage(int currPage, int pageSize);

	Map<String, Object> findPostsListByCategoryByPage(String categoryName, int currPage, int pageSize);

	Map<String, Object> findPostDetailsAndCommentsByPostId(Long postId);

	Map<String, Object> findPostsBetweenDateRange(String start, String end);

}
