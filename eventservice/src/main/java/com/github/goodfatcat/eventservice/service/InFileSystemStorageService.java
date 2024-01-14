package com.github.goodfatcat.eventservice.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.goodfatcat.eventservice.config.FileConfiguration;
import com.github.goodfatcat.eventservice.util.SupportedFileChecker;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class InFileSystemStorageService implements StorageService {
	private SupportedFileChecker checker;
	private FileConfiguration configuration;

	@Override
	public List<String> saveFiles(String fileNamePrefix, MultipartFile[] files) {
		List<String> fileNames = new ArrayList<>();
		
		Arrays.stream(files).forEach(file -> {
			checker.isFileSupported(file);
			
			String fileName = fileNamePrefix + file.getOriginalFilename();
			
			Path copyTo = Path.of(configuration.getDirectoryToSaveFiles() + "\\" + fileName);
			
			try(InputStream fileInputStream = file.getInputStream()) {
				Files.copy(fileInputStream, copyTo, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				log.error(e.getMessage());
				throw new RuntimeException(e);
			}
			
			fileNames.add(fileName);
		});
		
		return fileNames;
	}

}
