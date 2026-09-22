package com.eazybytes.ex2.config;


import com.eazybytes.ex2.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;

/**
 * PROVIDING CUSTOM NAMES TO YOUR SPRING BEAN
 * */

@Configuration
public class AnotherProjectConfig {

 @Bean
    String helloWorld(){
     return "hello world";
 }

 @Bean
    Integer luckyNumber(){
     return 16;
 }
}
