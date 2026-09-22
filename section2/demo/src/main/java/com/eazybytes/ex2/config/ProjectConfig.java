package com.eazybytes.ex2.config;


import com.eazybytes.ex2.beans.Vehicle;
import org.springframework.context.annotation.*;

/**
 * PROVIDING CUSTOM NAMES TO YOUR SPRING BEAN
 * */

@Configuration
@Import({AnotherProjectConfig.class})
public class ProjectConfig {

    @Bean(name ="audiVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Bean(name ="hondaVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

//    @Bean(name ="ferrariVehicle")
    @Primary
    @Bean({"ferrariVehicle","myFavouriteVehicle"})
    @Description("This is a vehicle class bean")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }
}
