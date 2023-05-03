package com.watchdog.watchdog.errorhandler;

public class AccessoryNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  public AccessoryNotFoundException(String message) {
    super(message);
  }

}
 