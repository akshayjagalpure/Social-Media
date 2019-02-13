package com.social.media.web.dto;

public class UniversityDto {

	private String branch;
	private String year;
	private byte[] syllabus;

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
