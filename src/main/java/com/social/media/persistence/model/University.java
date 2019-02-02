package com.social.media.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class University implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;

	public University() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "University{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}