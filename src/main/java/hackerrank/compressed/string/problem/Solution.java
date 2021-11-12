package hackerrank.compressed.string.problem;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'betterCompression' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

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

                while (++j < s.length() && !Character.isLetter(s.charAt(j))){
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

        return prepareBeautifiedString(charToOccurance);
    }

    public static String prepareBeautifiedString(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream().forEach(es -> {
            sb.append(es.getKey());
            sb.append(es.getValue());
        });
        return sb.toString();
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            valueToIndex.put(nums[i], i);
        }

        for (int i = 0 ; i < nums.length ; i++) {
            int magicNumber = target - nums[i];

            if (valueToIndex.get(magicNumber) != null) {
                return new int[] {i,valueToIndex.get(magicNumber)};
            }
        }

        // ------------

        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = 0 ; j < nums.length ; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        return new int[]{};
    }

}

class Entry {
    Character character;
    Integer occurance;
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.betterCompression(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
