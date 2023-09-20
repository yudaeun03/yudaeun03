package com.kh.springhome.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.email")
public class EmailProperties {
	private String host;
	private int port;
	private String username, password;
}



