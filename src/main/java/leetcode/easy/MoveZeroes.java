package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes tester = new MoveZeroes();
        int[] t1 = {0, 1, 0, 3, 12};
        tester.moveZeroes(t1);
        tester.printArray(t1);
        int[] t2 = {0, 1};
        tester.moveZeroes(t2);
        tester.printArray(t2);
        int[] t3 = {0, 0, 1};
        tester.moveZeroes(t3);
        tester.printArray(t3);
        int[] t4 = {0, 1, 0, 3};
        tester.moveZeroes(t4);
        tester.printArray(t4);
    }

    //0이 맨 앞에 두 개 나오면, 맨 앞의 0이 맨 뒤로 보내진 다음 '맨 앞'에 0이 남아있다.
    //인덱스가 1이 되기 때문에, 새로 맨 앞에 위치하게 된 0을 뒤로 보낼 수가 없게 된다.
    public void moveZeroes(int[] nums) {

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else {
                nums[i - zeroCount] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
