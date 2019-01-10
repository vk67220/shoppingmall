package com.shoppingmall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author muraliprasanth.n
 */
@SpringBootApplication
public class ShoppingmallApplication {
  Logger logger = LoggerFactory.getLogger(getClass().getName());

  public static void main(String[] args) {
    SpringApplication.run(ShoppingmallApplication.class, args);
  }

  @Scheduled(initialDelay = 1000, fixedRate = 10000)
  public void run() {
    logger.info("logging shopping mall app at " + LocalDateTime.now());
  }
}
