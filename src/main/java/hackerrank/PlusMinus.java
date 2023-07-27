package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        PlusMinus tester = new PlusMinus();
        tester.plusMinus(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, -1)));
    }

    public void plusMinus(List<Integer> arr) {
        // Write your code here
        int positives = 0;
        int negatives = 0;
        int zeros = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positives++;
            } else if (arr.get(i) < 0) {
                negatives++;
            } else {
                zeros++;
            }
        }
        float a = (float) positives / arr.size();
        float b = (float) negatives / arr.size();
        float c = (float) zeros / arr.size();
        System.out.printf("%1.6f\n", positives);
        System.out.printf("%1.6f\n", b);
        System.out.printf("%1.6f", c);
    }
}