package com.ace.company_news.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDTO {

	private int com_idx;
	private int news_idx;
	private MultipartFile news_file;
	
	public FileUploadDTO() {
		super();
	}

	public FileUploadDTO(int com_idx, int news_idx, MultipartFile news_file) {
		super();
		this.com_idx = com_idx;
		this.news_idx = news_idx;
		this.news_file = news_file;
	}

	public int getCom_idx() {
		return com_idx;
	}

	public void setCom_idx(int com_idx) {
		this.com_idx = com_idx;
	}

	public int getNews_idx() {
		return news_idx;
	}

	public void setNews_idx(int news_idx) {
		this.news_idx = news_idx;
	}

	public MultipartFile getNews_file() {
		return news_file;
	}

	public void setNews_file(MultipartFile news_file) {
		this.news_file = news_file;
	}
	
	
}
