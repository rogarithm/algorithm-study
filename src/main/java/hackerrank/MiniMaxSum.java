package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MiniMaxSum {

    public static void main(String[] args) {
        miniMaxSum(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        // sum 1-4, 2-5, 1 3-5, 1-2 4-5, ..
        Long max = addAllExcept(arr, 0);
        Long min = addAllExcept(arr, 0);
        for (int i = 1; i < arr.size(); i++) {
            Long candidate = addAllExcept(arr, i);
            if (candidate > max) {
                max = candidate;
            } else if (candidate < min) {
                min = candidate;
            }
        }
        System.out.printf("%d %d\n", min, max);
    }

    public static Long addAllExcept(List<Integer> arr, int i) {
        Long sum = 0L;
        for (int j = 0; j < arr.size(); j++) {
            if (i != j) {
                sum += arr.get(j);
            }
        }
        return sum;
    }
}