package com.by.khodasartyom.model.security;




import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;



import java.time.Duration;



@ConfigurationProperties(prefix = "booking.access-token")
@Value
@RequiredArgsConstructor

public class AccessTokenProperties {
    String secret;
    Duration timeToLive;

}
