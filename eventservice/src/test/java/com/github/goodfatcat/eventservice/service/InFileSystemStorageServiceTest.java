package com.github.goodfatcat.eventservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.goodfatcat.eventservice.config.FileConfiguration;
import com.github.goodfatcat.eventservice.util.SupportedFileChecker;

class InFileSystemStorageServiceTest {

	private SupportedFileChecker checker = mock(SupportedFileChecker.class);
	private FileConfiguration configuration = mock(FileConfiguration.class);
	private InFileSystemStorageService storageService = new InFileSystemStorageService(
			checker, configuration);

	@BeforeAll
	static void createTempDirectory() throws IOException {
		Files.createDirectory(Path.of("test"));
	}

	@Test
	void shouldProperlySaveFile() {
		String filePrefix = "test-2023-12-05-";
		MultipartFile file = new MockMultipartFile("mockfile", "file.jpg",
				"image/jpeg", new byte[]{1, 2, 3});

		when(checker.isFileSupported(file)).thenReturn(true);
		when(configuration.getDirectoryToSaveFiles()).thenReturn("test");

		List<String> actual = storageService.saveFiles(filePrefix,
				new MultipartFile[]{file});

		List<String> expected = List
				.of(filePrefix + file.getOriginalFilename());
		
		assertEquals(expected, actual);
		verify(checker).isFileSupported(file);
		assertTrue(Files.exists(Path.of(configuration.getDirectoryToSaveFiles()
				+ "/" + actual.get(0))));
	}

	@AfterAll
	static void deleteFilesAfterTests() throws IOException {
		FileSystemUtils.deleteRecursively(Path.of("test"));
	}

}
