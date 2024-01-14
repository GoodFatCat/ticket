package com.github.goodfatcat.eventservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	List<String> saveFiles(String fileNamePrefix, MultipartFile[] files);
}
