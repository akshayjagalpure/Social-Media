package com.social.media.web.dto;

public class UniversityDto {

	private String branch;
	private String year;
	private byte[] syllabus;
	private String branch1;
	private String year1;
	private byte[] result;

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

	public String getBranch1() {
		return branch1;
	}

	public void setBranch1(String branch1) {
		this.branch1 = branch1;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public byte[] getresult(){return result;}

	public void setresult(byte[] result){this.result=result;}
}
