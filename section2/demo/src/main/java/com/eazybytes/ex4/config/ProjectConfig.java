package com.eazybytes.ex4.config;


import com.eazybytes.ex4.beans.Person;
import com.eazybytes.ex4.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Using @Component annotation
 * */

@Configuration
@ComponentScan(basePackages = {"com.eazybytes.ex4.beans"})
public class ProjectConfig {

    @Bean
            Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return  vehicle;
    }


    /**
     * WIRING BEANS USING METHOD CALL
     * */
  /*  @Bean
    Person person() {
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle());
        return person;
    }*/

    /**
     * WIRING BEANS USING METHOD PARAMETERS
     * */
    @Bean
    Person person(Vehicle vehicle) {
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle);
        return person;
    }

}
