package hackerrank.compressed.string.problem;

public class Example {

    public static void main(String[] args) {
        System.out.println(switchWord("Hello, how are you?", 7));
    }



    static String switchWord(String input, int position){
        final StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(position));

        int i = position;
        while (i <= input.length() && input.charAt(i++) != ' ') {
            sb.append(input.charAt(i));
        }

        final String revWord = sb.reverse().toString();
        int length = revWord.length();

        char[] inputArray = input.toCharArray();

        for (int j = 0 ; j < inputArray.length ; j++) {

            if (j == position) {
//                inputArray[1] =
            }
        }


        // Iterate through inputArray, by each char using the index, starting with 0
        // if index == position
            //  inputArray[j] =


        return "";
    }


    }

