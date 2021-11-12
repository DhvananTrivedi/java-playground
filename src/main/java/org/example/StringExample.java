package org.example;

import java.util.HashMap;
import java.util.Map;

public class StringExample {
    public static void main(String[] args) {

        System.out.println(betterCompression("a12b56c1"));
    }

    public static String betterCompression(String s) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        final Map<Character, Integer> charToOccurance = new HashMap<>();

        for (int i =0 ; i <s.length() ; i++) {

            if(Character.isLetter(s.charAt(i))) {
                int j = i;
                Entry e = new Entry();
                e.character = s.charAt(i);

                // now find it's quoted occurance
                final StringBuilder occurance = new StringBuilder();

                Character.isLetter(s.charAt(j++));
                while (!Character.isLetter(s.charAt(j++))){
                    occurance.append(s.charAt(j));
                }


                e.occurance = Integer.parseInt(occurance.toString());

                // Now we manage the count
                final Integer existingCount = charToOccurance.get(e.character);
                if(existingCount == null) {
                    charToOccurance.put(e.character, e.occurance);
                } else {
                    e.occurance = existingCount + e.occurance;
                    charToOccurance.put(e.character, e.occurance);
                }

            }

        }
        return charToOccurance.toString();
    }
}

class Entry {
    Character character;
    Integer occurance;
}
