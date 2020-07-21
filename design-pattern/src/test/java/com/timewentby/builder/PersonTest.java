package com.timewentby.builder;


import org.junit.Test;

public class PersonTest {

    @Test
    public void builderTest() {
        Person person = Person.builder()
                .name("xy")
                .age(26)
                .build();
        System.out.println(person);

    }
}