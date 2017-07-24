package com.welloculus.iotgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.welloculus.iotgateway.util.CustomLogger;

@Configuration
@SpringBootApplication
public class IOTGatewayApplication{

  static CustomLogger logger = CustomLogger.getLogger();
  
  public static void main(String[] args) {
    SpringApplication.run(IOTGatewayApplication.class, args);
  }

}
