package org.scorpion.easyrental.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.scorpion.easyrental")
@EnableWebMvc
public class WebAppConfig {

}
