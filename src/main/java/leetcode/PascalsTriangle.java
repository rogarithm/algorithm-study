package leetcode;

// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle tester = new PascalsTriangle();
        System.out.println(tester.generate(1));
        System.out.println(tester.generate(2));
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<Integer> elem = new ArrayList<>();
        elem.add(1);
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(elem);

        return result;
    }
}
