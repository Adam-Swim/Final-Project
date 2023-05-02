package com.watchdog.watchdog.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetails {
  private Long id;
  private Accessory accessory;
  private Order order;

}
