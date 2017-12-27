package com.ssm.service;

import org.springframework.web.multipart.MultipartFile;

import com.ssm.entity.Image;


public interface ImageService {

	public String[][] identifyImage(Image image, String fileString, String path);
}
