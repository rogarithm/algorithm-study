package leetcode;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber tester = new SingleNumber();
        System.out.println(tester.singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        return 1;
    }
}
