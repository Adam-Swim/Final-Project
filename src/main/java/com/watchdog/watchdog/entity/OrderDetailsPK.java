package com.watchdog.watchdog.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailsPK implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Column(name = "accessory_fk")
  private int accessoryFk;
  
  @Column(name = "order_fk")
  private int orderFk;
  

  public int getAccessoryFk() {
    return accessoryFk;
  }

  public void setAccessoryFk(int accessoryFk) {
    this.accessoryFk = accessoryFk;
  }

  public int getOrderFk() {
    return orderFk;
  }

  public void setOrderFk(int orderFk) {
    this.orderFk = orderFk;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderDetailsPK that = (OrderDetailsPK) o;
    return accessoryFk == that.accessoryFk && orderFk == that.orderFk;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(accessoryFk, orderFk);
  }

}
