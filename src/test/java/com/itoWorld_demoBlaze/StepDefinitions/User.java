package com.itoWorld_demoBlaze.StepDefinitions;

import com.github.javafaker.Faker;

public class User {

    private final String username;
    private final String password;

    public User(){
        Faker faker = new Faker();
        username = faker.name().username();
        password = faker.internet().password();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
