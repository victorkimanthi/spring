package com.eazybytes.ex5.config;


import com.eazybytes.ex4.beans.Person;
import com.eazybytes.ex4.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Using @Component annotation
 * */

@Configuration
@ComponentScan(basePackages = {"com.eazybytes.ex5.beans"})
public class ProjectConfig {

}
