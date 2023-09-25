package com.by.khodasartyom;



import com.by.khodasartyom.model.security.AccessTokenProperties;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;



@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@ConfigurationPropertiesScan("com.by.khodasartyom.model.security")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
