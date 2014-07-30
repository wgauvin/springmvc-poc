package net.gauvins.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "net.gauvins")
public class BaseConfiguration {

}
