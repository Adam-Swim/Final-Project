package com.watchdog.watchdog.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.watchdog.watchdog.entity.Accessory;
import com.watchdog.watchdog.entity.Customers;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;
import com.watchdog.watchdog.errorhandler.AccessoryNotFoundException;
import com.watchdog.watchdog.repository.CustomerRepository;

@Component
public class DefaultWatchdogOrderDao implements WatchdogOrderDao {
  
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
  @Autowired
  private CustomerRepository customerRepository;
  
  private static class SqlParams {
    String sql;
    SqlParameterSource source;
}


  @Override
  public List<Accessory> FetchAccessories(List<String> accessoryIds) {
    
    String sql = "SELECT * FROM accessories WHERE accessory_id IN (:accessoryIds)";
    MapSqlParameterSource params = new MapSqlParameterSource("accessoryIds", accessoryIds);
    List<Accessory> accessories = namedParameterJdbcTemplate.query(sql, params, (resultSet, rowNum) -> {
      Long accessoryPK = resultSet.getLong("accessoryPK");
      String accessoryId = resultSet.getString("accessory_id");
      String name = resultSet.getString("name");
      String manufacturer = resultSet.getString("manufacturer");
      String description = resultSet.getString("description");
      BigDecimal price = resultSet.getBigDecimal("price");
      
      return Accessory.builder()
          .accesspryPK(accessoryPK)
          .accessoryId(accessoryId)
          .name(name)
          .manufacturer(manufacturer)
          .description(description)
          .price(price)
          .build();
    });
    
    
    if (accessories.size() != accessoryIds.size()) {
      throw new AccessoryNotFoundException(
          
          "One or more accessoryIds not found in the database"
          
          );
    }
    
    return accessories;
  }

  @Override
  public Optional<Customers> fetchCustomers(String customerId) {
      String sql = "SELECT * FROM customers WHERE customer_id = :customerId";
      MapSqlParameterSource params = new MapSqlParameterSource("customerId", customerId);
      try {
          Customers customer = namedParameterJdbcTemplate.queryForObject(sql, params, (resultSet, rowNum) -> {
              Long customerPK = resultSet.getLong("customerPK");
              String id = resultSet.getString("customer_id");
              String name = resultSet.getString("customer_name");
              String contact = resultSet.getString("contact");
              return new Customers(customerPK, id, name, contact);
          });
          return Optional.ofNullable(customer);
      } catch (EmptyResultDataAccessException e) {
          return Optional.empty();
      }
  }

  @Override
  public Optional<Watchdog> fetchModel(String watchdogId, WatchdogModel model, int mastHeight, int panelWatts) {
//    String sql = "SELECT * FROM watchdog WHERE watchdog_id = :watchdogId";
    String sql = "SELECT * FROM watchdog WHERE watchdog_id = :watchdogId AND watchdog_model = :watchdogModel AND mast_height = :mastHeight AND panel_watts = :panelWatts";
    MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("watchdogId", watchdogId)
        .addValue("watchdogModel", model.toString())
        .addValue("mastHeight", mastHeight)
        .addValue("panelWatts", panelWatts);
    
    try {
      Watchdog watchdog = namedParameterJdbcTemplate.queryForObject(sql, params, (resultSet, rowNum) -> {
        Long watchdogPK = resultSet.getLong("watchdogPK");
        String id = resultSet.getString("watchdog_id");
        int mastHeightLocal = resultSet.getInt("mast_height");
        int panelWattsLocal = resultSet.getInt("panel_watts");
        String description = resultSet.getString("description");
        BigDecimal price = resultSet.getBigDecimal("price");
        WatchdogModel watchdogModel = WatchdogModel.valueOf(resultSet.getString("watchdog_model"));
        return new Watchdog(watchdogPK, id, mastHeightLocal, panelWattsLocal, description, price, watchdogModel);
      });
    
    return Optional.ofNullable(watchdog);
    }catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
    
  }

  @Override
  public Order saveOrder(Customers customer, Watchdog watchdog, List<Accessory> accessories, BigDecimal price) {
    SqlParams params = generateInsertSql(customer, watchdog, accessories, price);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    namedParameterJdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    
    saveAccessories(accessories, orderPK);
    
    
   // @formatter:off
    return Order.builder()
        .orderPk(orderPK)
        .customer(customer)
        .watchdog(watchdog)
        .totalPrice(price)
        .accessories(accessories)
        .build();
    
    // @formatter:on
  }
   private void saveAccessories(List<Accessory> accessories, Long orderPK) {
     for (Accessory accessory : accessories) {
       SqlParams params = generateInsertSqlForAccessory(accessory, orderPK);
       namedParameterJdbcTemplate.update(params.sql, params.source);
     }
   }
   
   
   private SqlParams generateInsertSql(Customers customer, Watchdog watchdog, List<Accessory> accessories, BigDecimal price) {
     SqlParams params = new SqlParams();
     params.sql =
       // @formatter:off
         "INSERT INTO orders"
         + " (customer_id,"
         + " watchdog_id,"
         + " price) "
         + "VALUES"
         + " (:customerId,"
         + " :watchdogId,"
         + " :price)";
      // @formatter:on 

     params.source = new MapSqlParameterSource()
             .addValue("customerId", customer.getCustomerId())
             .addValue("watchdogId", watchdog.getWatchdogId())
             .addValue("price", price);

     return params;
 }

   private SqlParams generateInsertSqlForAccessory(Accessory accessory, Long orderPK) {
     SqlParams params = new SqlParams();
     params.sql =
       // @formatter:off
         "INSERT INTO order_details"
         + " (order_id,"
         + " accessory_id "
         + "VALUES"
         + " (:orderId,"
         + " :accessoryId";
      
       // @formatter:on

     params.source = new MapSqlParameterSource()
             .addValue("orderId", orderPK)
             .addValue("accessoryId", accessory.getAccessoryId());
             

     return params;
   }


}
