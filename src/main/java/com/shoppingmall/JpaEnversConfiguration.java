package com.shoppingmall;

import com.shoppingmall.config.FileStorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableConfigurationProperties(FileStorageProperties.class)
public class JpaEnversConfiguration {
}
