package com.shoppingmall.shoppingmall;

import com.shoppingmall.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
public class CustomersIntegrationTest {

  @LocalServerPort
  int randomServerPort;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void getCustomersWithId() throws Exception {
    Customer mockCustomer = new Customer();
    mockCustomer.setFirstName("bobby");
    mockCustomer.setCreatedAt(new Date());
    mockCustomer.setUpdatedAt(new Date());
    String uri = "/api/customers/141";
    HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(null);
    ResponseEntity<String> result =
          testRestTemplate.exchange(fromFullUrlWithPort(uri), HttpMethod.GET, customerHttpEntity, String.class);
    Assert.assertEquals(true, result.getBody().contains("Diego"));
  }

  private String fromFullUrlWithPort(String uri) {
    return "http://localhost:" + randomServerPort + uri;
  }

}
