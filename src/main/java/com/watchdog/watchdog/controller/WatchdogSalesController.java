package com.watchdog.watchdog.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/watchdogs")
public interface WatchdogSalesController {
  
 
  
//@formatter:off
 @Operation(
     summary = "Returns a list of Watchdogs",
     description = "Returns a list of Watchdogs given an optional model",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "A list of Watchdogs is returned.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Watchdog.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No watchdogss were found woth the input criteria.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred.", 
             content = @Content(mediaType = "application/json"))
     }
     
  )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Watchdog> fetchWatchdogs(@RequestParam WatchdogModel model);
 
 @PutMapping("/orders/{id}")
 public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId, @Valid @RequestBody Order orderDetails);
 

}
