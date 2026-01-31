package com.hehe.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/file")
public class FileController {

	@Value("${path.file.download}")
	private String downloadDirectory;
	
	@Value("${path.file.upload}")
	private String uploadDirectory;
	
	@GetMapping(value = "/download/MarketAnalysisSeptember2021.pdf")
	public ResponseEntity<Object> downloadFile() throws MalformedURLException {
		Path filePath = Paths.get(downloadDirectory).normalize();
		Resource resource = new UrlResource(filePath.toUri());
		if(!resource.exists() || !resource.isReadable()) {
			throw new RuntimeException("File not found: " + resource.getFilename());
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(filePath.toFile().length());
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", resource.getFilename());
		
		return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/upload")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		Path path = Paths.get(uploadDirectory).normalize();
		Resource resource = new UrlResource(path.toUri());
		if (!resource.exists())
			Files.createDirectory(Paths.get(uploadDirectory));
		Path filePath = Paths.get(uploadDirectory + file.getOriginalFilename());
		file.transferTo(filePath);
		
		return new ResponseEntity<Object>("File uploaded successfully: " + file.getOriginalFilename(), HttpStatus.OK);
	}
}
