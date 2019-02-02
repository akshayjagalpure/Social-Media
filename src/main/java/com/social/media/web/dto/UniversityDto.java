package com.social.media.web.dto;

public class UniversityDto {

	private String title;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "UniversityDto{" +
				"title='" + title + '\'' +
				'}';
	}
}
