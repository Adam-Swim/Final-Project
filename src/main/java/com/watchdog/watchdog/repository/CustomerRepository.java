package com.watchdog.watchdog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.watchdog.watchdog.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
