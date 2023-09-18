package com.by.khodasartyom.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import java.time.Duration;


@Getter
@Setter
@NoArgsConstructor
@AutoConfiguration
@Configuration
@ConfigurationProperties(prefix = "booking.access-token")
public class AccessTokenProperties {

    String secret;
    Duration timeToLive;

}
