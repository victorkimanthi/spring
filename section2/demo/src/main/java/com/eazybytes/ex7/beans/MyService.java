package com.eazybytes.ex7.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Lazy
public class MyService {

    public MyService() {
        System.out.println("MyService bean is created");
    }
}