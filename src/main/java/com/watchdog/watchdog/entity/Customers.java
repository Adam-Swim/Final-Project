package com.watchdog.watchdog.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Customers {
  private Long customerPK;
  private String customerId;
  private String customerName;
  private String contact;

  
  public Customers(Long customerPK, String customerId, String customerName, String contact) {
    this.customerPK = customerPK;
    this.customerId = customerId;
    this.customerName = customerName;
    this.contact = contact;
  }
  
  
  
}
