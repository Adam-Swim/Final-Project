package com.watchdog.watchdog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.watchdog.watchdog.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
