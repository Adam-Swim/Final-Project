package com.watchdog.watchdog.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "orders")
public class Order {
  
  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customers customer;
  
  public Customers getCustomer() {
    return customer;
  }
  
  public void setCustomer(Customers customer) {
    this.customer = customer;
  }
  
  
  @ManyToOne
  @JoinColumn(name = "watchdog_id", nullable = false)
  private Watchdog watchdog;
  
  public Watchdog getWatchdog() {
    return watchdog;
  }
  
  public void setWatchdog(Watchdog watchdog) {
    this.watchdog = watchdog;
  }
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_pk")
  private Long orderPk;
  private BigDecimal totalPrice;
  
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<Accessory> accessories;
}
