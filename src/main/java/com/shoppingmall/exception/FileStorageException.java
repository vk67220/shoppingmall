package com.shoppingmall.exception;

/**
 * @author muraliprasanth.n
 */
public class FileStorageException extends RuntimeException {
  public FileStorageException(String s, Exception ex) {
    super(s);
  }

  public FileStorageException(String message) {
    super(message);
  }
}
