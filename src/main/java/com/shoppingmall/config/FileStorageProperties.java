package com.shoppingmall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author muraliprasanth.n
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

  private String uploadDir;

  public String getUploadDir() {
    return uploadDir;
  }

  public void setUploadDir(String uploadDir) {
    this.uploadDir = uploadDir;
  }
}
