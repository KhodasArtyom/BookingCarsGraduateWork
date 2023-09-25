package com.by.khodasartyom.model.security;




import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.time.Duration;




@Component
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix="booking.access-token")
public class AccessTokenProperties {
    String secret;
    Duration timeToLive;

}
