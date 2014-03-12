package com.truste.app.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages =
        {"com.truste.app.service"
        })
public class ApplicationConfig
{

}
