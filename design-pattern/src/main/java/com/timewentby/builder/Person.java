package com.timewentby.builder;

public class Person {

    private String name;
    private Integer age;

    private Person() {

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class PersonBuilder {

        private String name;
        private Integer age;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.name = this.name;
            person.age = this.age;
            return person;
        }

    }

}
