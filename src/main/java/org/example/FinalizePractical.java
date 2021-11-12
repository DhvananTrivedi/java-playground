package org.example;

public class FinalizePractical {

    public static void main(String[] args) {
        init();

        System.out.println("I'm starting.");

        for (int i = 0; i <120000000; i++) {

        }

        doSomething();
    }

    static void init() {
        Person dhvanan = new Person();
        dhvanan.age = 24;
    }

    static void doSomething() {
        System.out.println("Really just want to chill.");
    }
}

class Person {
    int age;

    @Override
    public void finalize() {
        System.out.println("I'm getting finalised! My age is " + age);
    }
}
