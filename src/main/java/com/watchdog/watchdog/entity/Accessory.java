package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Accessory {
  private Long accesspryPK;
  private String accessoryId;
  private String name;
  private String manufacturer;
  private String description;
  private BigDecimal price;
  

}
