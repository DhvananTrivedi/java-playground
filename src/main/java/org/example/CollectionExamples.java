package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionExamples {
    public static void main(String[] args) {

        // 1. Arrays.asList returns a fixed size list
        List<String> fixedSizeList = Arrays.asList(new String[]{"ac","bddefe"});
//        fixedSizeList.remove(0); -> This will give UnsupportedOperationException
        System.out.println(fixedSizeList);

        // this one way to go around it.
        List<String> flexibleList = new ArrayList<>(fixedSizeList);
        flexibleList.remove(0);
        System.out.println(flexibleList);

        // makes unmodifiable list
        List<String> unmodifiableList = Collections.unmodifiableList(flexibleList);


    }

}

class Student {
    int id;
    String name;
}