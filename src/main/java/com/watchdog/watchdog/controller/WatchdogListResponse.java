package com.watchdog.watchdog.controller;

import java.util.List;
import com.watchdog.watchdog.entity.Watchdog;

public class WatchdogListResponse {
  private List<Watchdog> watchdogs;
  
  public List<Watchdog> getWatchdogs() {
    return watchdogs;
  }
  
  public void setWatchdogs(List<Watchdog> watchdogs) {
    this.watchdogs = watchdogs;
  }

}
