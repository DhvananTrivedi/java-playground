package org.example;

public class InterfaceMultipleInheritance {
    public static void main(String[] args) {
        Child c = new Child();

        c.print();
        c.uniqueToParent1();
    }
}

class Child implements Parent1, Parent2 {
    
    @Override
    public void print() {
        // the compiler forces us to override "print()", because its coming from multiple sources.
        // for methods unique to a single interface, we dont have to override it.
        System.out.println("Child");
    }
}

interface Parent1 {
    default void print() {
        System.out.println("Parent 1");
    }

    default void uniqueToParent1() {
        System.out.println("This method is unique to Parent 1");
    }

}

interface Parent2 {
    default void print() {
        System.out.println("Parent 2");
    }
}