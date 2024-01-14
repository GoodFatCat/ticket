package com.github.goodfatcat.eventservice.util;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.github.goodfatcat.eventservice.config.FileConfiguration;
import com.github.goodfatcat.eventservice.exception.EmptyFileException;
import com.github.goodfatcat.eventservice.exception.UnsupportedFileException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class SupportedFileChecker {
	
	private FileConfiguration supportedFilesConfiguration;
	
	public boolean isFileSupported(MultipartFile file) {
		if (file.isEmpty()) {
			log.info(file.toString() + " is empty");
			throw new EmptyFileException("File must be not empty");
		}
		String fileType = file.getContentType().split("/")[0];
		long count = Arrays.stream(supportedFilesConfiguration.getTypes())
				.filter(type -> type.equals(fileType))
				.count();	
		if (count == 0) {
			log.info(file.toString() + " is unsupported");
			throw new UnsupportedFileException(String.format("File type %s is not supported", file.getContentType()));
		}
		return count > 0;
	}
}
