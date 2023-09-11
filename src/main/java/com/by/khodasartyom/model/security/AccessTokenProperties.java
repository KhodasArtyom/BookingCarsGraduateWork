package com.by.khodasartyom.model.security;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


import java.time.Duration;

@ConfigurationPropertiesScan(prefix = "booking.access-token")
@Value
public class AccessTokenProperties {
    String secret;
    Duration timeToLive;



}
