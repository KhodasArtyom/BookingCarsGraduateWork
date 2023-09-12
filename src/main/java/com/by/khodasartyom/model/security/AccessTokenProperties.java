package com.by.khodasartyom.model.security;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import java.time.Duration;

@EnableConfigurationProperties(AccessTokenProperties.class)
@ConfigurationProperties(prefix = "booking-cars.access-token" )
@Value
public class AccessTokenProperties {
    String secret;
    Duration timeToLive;



}
