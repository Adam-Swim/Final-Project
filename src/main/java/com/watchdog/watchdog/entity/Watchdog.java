package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "watchdogs")
public class Watchdog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "watchdog_pk")
  private Long watchdogPK;
  private String watchdogId;
  private int mastHeight;
  private int panelWatts;
  private String description;
  private BigDecimal price;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "watchdog_model")
  private WatchdogModel watchdogModel;
  
  public Watchdog(
      // @formatter:off
      Long watchdogPK,
      String watchdogId,
      int mastHeight,
      int panelWatts,
      String description,
      BigDecimal price,
      WatchdogModel watchdogModel) {
      // @formatter:on
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
