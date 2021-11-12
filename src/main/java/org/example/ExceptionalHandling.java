package org.example;

public class ExceptionalHandling {
    public static void main(String[] args) {
        System.out.println("The returned string was = " + sample());
    }

    public static String sample() {
        Something sm = new Something();
        try {
            return sm.getName();
        } catch (Exception e) {
            return "catch block";
        } finally {
            sm.close();
        }
    }
}

class Something {

    public String getName(){
        System.out.println("Get name was called!");
        return "Dhvanan";
    }

    public void close() {
        System.out.println("Closing method called!");
    }

}
