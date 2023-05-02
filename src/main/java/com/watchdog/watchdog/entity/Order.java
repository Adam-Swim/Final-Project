package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
  private Long orderPk;
  private String customerId;
  private String watchdogId;
  private BigDecimal totalPrice;
  private List<Accessory> accessories;
}
