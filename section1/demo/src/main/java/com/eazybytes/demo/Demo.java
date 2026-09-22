package com.eazybytes.demo;

import com.eazybytes.demo.beans.Vehicle;
import com.eazybytes.demo.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.Inet4Address;

public class Demo {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        System.out.println("Vehicle name from non-spring context is: "+vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var  veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring context is: "+veh.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring context is: "+hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring context is: "+num);

//        context.getBean(Double.class);
    }
}
