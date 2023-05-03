package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
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
@Table(name = "watchdog")
public class Watchdog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long watchdogPK;
  private String watchdogId;
  private int mastHeight;
  private int panelWatts;
  private String description;
  private BigDecimal price;
  
  public Watchdog(Long watchdogPK, String watchdogId, int mastHeight, int panelWatts, String description, BigDecimal price) {
    this.watchdogPK = watchdogPK;
    this.watchdogId = watchdogId;
    this.mastHeight = mastHeight;
    this.panelWatts = panelWatts;
    this.description = description;
    this.price = price;
  }
  
  public Watchdog() {
    
  }
}
