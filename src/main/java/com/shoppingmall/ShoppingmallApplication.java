package com.shoppingmall;

import com.shoppingmall.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author muraliprasanth.n
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(FileStorageProperties.class)
public class ShoppingmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}
}
