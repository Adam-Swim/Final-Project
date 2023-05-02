package com.watchdog.watchdog.entity;

import java.util.List;

public class OrderRequest {
  private String customerId;
  private WatchdogModel model;
  private List<String> accessoryIds;
  public String getCustomerId() {
    return customerId;
  }
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }
  public WatchdogModel getModel() {
    return model;
  }
  public void setModel(WatchdogModel model) {
    this.model = model;
  }
  public List<String> getAccesoryIds() {
    return accessoryIds;
  }
  public void setAccesoryIds(List<String> accesoryIds) {
    this.accessoryIds = accesoryIds;
  }
  
  

}
