package com.watchdog.watchdog.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "order_details")

public class OrderDetails {
  
  @EmbeddedId
  private OrderDetailsPK orderDetailsPK;
  
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "accessory_fk", insertable = false, updatable = false)
  private Accessory accessory;
  
  @ManyToOne
  @JoinColumn(name = "order_fk", insertable = false, updatable = false)
  private Order order;

}
