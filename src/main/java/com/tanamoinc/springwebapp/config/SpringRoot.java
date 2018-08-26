package com.tanamoinc.springwebapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Tanamo
 */
@Configuration
@ComponentScan(basePackages = {"com.tanamoinc.springwebapp.dao","com.tanamoinc.springwebapp.dao.services"})
public class SpringRoot {

}
