package com.watchdog.watchdog.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.core.ParameterizedTypeReference;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@ActiveProfiles("test")

//@Sql(
//    scripts = {
//        "classpath:/schema.sql",
//        "classpath:/data.sql"
//    })




class FetchWatchdogTest {
  
  
  @Autowired
 
  private TestRestTemplate restTemplate;
  
  @LocalServerPort
  private int serverPort;
  
  
  

  @Test
  void testThatWatchdogsAreReturnedWhenAValidModelIsSupplied() {
  
  
  //Given: a valid watchdog model and URI
  WatchdogModel model = WatchdogModel.POINTER;
  String uri = 
      String.format("http://localhost:%d/watchdogs", serverPort, model);
  
  //When: a connection is made to the URI
  ResponseEntity<List<Watchdog>> response =
      getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Watchdog>> () {});
  
  //Then: a success (OK - 200) status code is returned
  assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  
  //And: the actual list returned is the same as the expected list
  List<Watchdog> actual = response.getBody();
  List<Watchdog> expected = buildExpected();
  
  actual.forEach(watchdog -> watchdog.setWatchdogPK(null));
  
  assertThat(actual).isEqualTo(expected);
  }
  
  private TestRestTemplate getRestTemplate() {
    return restTemplate;
  }
  
  private List<Watchdog> buildExpected() {
    List<Watchdog> expectedWatchdogs = new ArrayList<>();
    
    Watchdog watchdog1 = new Watchdog(null, "BULLDOG", 9, 1650,
        "Bulldog solar mobile light tower", new BigDecimal("49900.00"));
    Watchdog watchdog2 = new Watchdog(null, "DOBERMAN", 9, 2200,
        "Doberman solar mobile light tower", new BigDecimal("59900.00"));
    Watchdog watchdog3 = new Watchdog(null, "POINTER", 9, 1650,
        "Pointer solar mobile communications tower", new BigDecimal("59900.00"));
    
    expectedWatchdogs.add(watchdog1);
    expectedWatchdogs.add(watchdog2);
    expectedWatchdogs.add(watchdog3);
    
    return expectedWatchdogs;
  }

}
