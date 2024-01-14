package com.github.goodfatcat.eventservice.config;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "files")
@Getter
@Setter
public class FileConfiguration {
	private String[] types;
	private String directoryToSaveFiles;
	
	@PostConstruct
	 public void createDirectory() throws IOException {
		try {
			Files.createDirectory(Path.of(directoryToSaveFiles));
		} catch (FileAlreadyExistsException e) {
			
		}
	}
}
