package com.watchdog.watchdog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "customers")

public class Customers {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_pk")
  private Long customerPK;
  private String customerId;
  private String customerName;
  private String contact;
  
  public Customers() {
    
  }

  
  public Customers(Long customerPK, String customerId, String customerName, String contact) {
    this.customerPK = customerPK;
    this.customerId = customerId;
    this.customerName = customerName;
    this.contact = contact;
  }
  
  
  
}
