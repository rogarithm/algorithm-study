package jdk;


public class StringTest {

    public static void main(String[] args) {

        for (String character : new String[]{"a", "b", "c"}) {
            System.out.println(character);
        }

        System.out.println("bad".contains("."));
        System.out.println(".ad".contains("."));
        System.out.println("a.d".contains("."));

        System.out.println("bad".indexOf(".") == -1);
        System.out.println(".ad".indexOf(".") == 0);
        System.out.println("a.d".indexOf(".") == 1);

        String word = "a.cd";
        int dotPosition = word.indexOf(".");
        for (String character : new String[]{"a", "b", "c"}) {
            System.out.println(word.substring(0, dotPosition)
                    + character
                    + word.substring(dotPosition + 1, word.length()));
        }
    }

}
