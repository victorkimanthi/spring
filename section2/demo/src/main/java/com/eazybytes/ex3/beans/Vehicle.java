package com.eazybytes.ex3.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
//public class Vehicle {
public class Vehicle implements InitializingBean, DisposableBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void sayHello(){
        System.out.println("Printing Hello from component Vehicle bean.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "Tesla";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying vehicle Bean.");
    }

    //form Jakarta Enterprise
   /* @PreDestroy
    public void destroy(){
        System.out.println("Destroying vehicle Bean.");
    }*/

    //form Jakarta Enterprise
   /* @PostConstruct
    public void initialize(){
        this.name = "Audi";
    }*/
}
