package com.practice.cryptoService.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "application.crypto")
public class AuthenticationConfiguration {
    @Value("key")
    public String key;
    @Value("ivKey")
    public String ivKey;

}
