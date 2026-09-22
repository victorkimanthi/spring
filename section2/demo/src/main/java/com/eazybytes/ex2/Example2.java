package com.eazybytes.ex2;

import com.eazybytes.ex2.beans.Vehicle;
import com.eazybytes.ex2.config.AnotherProjectConfig;
import com.eazybytes.ex2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var  veh = context.getBean("audiVehicle",Vehicle.class);
        System.out.println("Vehicle name from Spring context is: "+veh.getName());

        var  vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring context is: "+vehicle.getName());

        var  hellowWorld = context.getBean(String.class);
        System.out.println("Vehicle name from Spring context is: "+hellowWorld);
    }
}
