package com.github.goodfatcat.eventservice.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.github.goodfatcat.eventservice.config.FileConfiguration;
import com.github.goodfatcat.eventservice.exception.EmptyFileException;
import com.github.goodfatcat.eventservice.exception.UnsupportedFileException;

class SupportedFileCheckerTest {
	
	private FileConfiguration configuration = mock(FileConfiguration.class);
	private SupportedFileChecker checker = new SupportedFileChecker(configuration);

	@Test
	void shouldReturnTrue() {
		when(configuration.getTypes()).thenReturn(new String[]{"image"});
		
		MultipartFile mockMultipartFile = new MockMultipartFile("Multipartfile", "file.jpg", "image/jpeg", new byte[] {1,2,3});
		
		assertTrue(checker.isFileSupported(mockMultipartFile));
	}
	
	@Test
	void shouldThrowUnsupportedFileException() {
		when(configuration.getTypes()).thenReturn(new String[]{"image"});
		
		MultipartFile mockMultipartFile = new MockMultipartFile("Multipartfile", "file.mp4", "video/mp4", new byte[] {1,2,3});
		
		assertThrows(UnsupportedFileException.class, () -> checker.isFileSupported(mockMultipartFile));
	}
	
	@Test
	void shouldThrowEmptyFileException() {
		when(configuration.getTypes()).thenReturn(new String[]{"image"});
		
		MultipartFile mockMultipartFile = new MockMultipartFile("Multipartfile", "file.mp4", "video/mp4", new byte[] {});
		
		assertThrows(EmptyFileException.class, () -> checker.isFileSupported(mockMultipartFile));
	}

}
