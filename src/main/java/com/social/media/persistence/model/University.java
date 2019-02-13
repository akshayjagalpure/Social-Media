package com.social.media.persistence.model;

import com.social.media.util.TimeUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class University implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String branch;
	private String year;
	private byte[] syllabus;

	public University() {

	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public byte[] getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(byte[] syllabus) {
		this.syllabus = syllabus;
	}
}