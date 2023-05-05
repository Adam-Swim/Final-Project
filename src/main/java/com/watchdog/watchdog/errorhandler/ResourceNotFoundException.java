package com.watchdog.watchdog.errorhandler;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
}

}
