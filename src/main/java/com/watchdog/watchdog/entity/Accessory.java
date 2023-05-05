package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "accessories")
public class Accessory {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "accessory_pk")
  private Long accesspryPK;
  private String accessoryId;
  private String name;
  private String manufacturer;
  private String description;
  private BigDecimal price;
  
  @ManyToOne
  @JoinColumn(name = "order_fk")
  private Order order;

}
