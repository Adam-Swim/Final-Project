package com.watchdog.watchdog.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
  private Long orderPk;
  private int customerId;
  private int watchdogId;
  private double totalPrice;
}
