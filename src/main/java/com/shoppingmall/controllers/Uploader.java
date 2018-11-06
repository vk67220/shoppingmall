package com.shoppingmall.controllers;

import com.shoppingmall.dto.UploadFileResponse;
import com.shoppingmall.services.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muraliprasanth.n
 */
@RestController
@RequestMapping("/api")
public class Uploader {

  private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
  private FileStorageService fileStorageService;

  @Autowired
  public Uploader(FileStorageService fileStorageService) {
    this.fileStorageService = fileStorageService;
  }

  @PostMapping("/upload")
  public ResponseEntity<UploadFileResponse> handleFileUpload(@RequestParam("file") MultipartFile file) {
    String fileName = fileStorageService.storeFile(file);
    String fileURI = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path("/download")
          .path(fileName)
          .toUriString();

    return new ResponseEntity<>(
          new UploadFileResponse(fileName, fileURI, file.getContentType(), file.getSize()), HttpStatus.OK);
  }

  @PostMapping("/uploadMultipleFiles")
  public List<ResponseEntity<UploadFileResponse>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    return Arrays.asList(files)
          .stream()
          .map(this::handleFileUpload)
          .collect(Collectors.toList());
  }

  @GetMapping("/download/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
    Resource resource = fileStorageService.loadFileAsResource(fileName);

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      logger.info("Could not determine file type.");
    }

    if(contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
          .contentType(MediaType.parseMediaType(contentType))
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
  }
}
