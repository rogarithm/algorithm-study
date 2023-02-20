package leetcode.easy;

// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle tester = new PascalsTriangle();
        System.out.println(tester.generate(1));
        System.out.println(tester.generate(2));
        System.out.println(tester.generate(3));
        System.out.println(tester.generate(4));
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return null;
        }

        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> elemsAtRow = prepareElemsAtRow(i, result);
            result.add(elemsAtRow);
        }

        return result;
    }

    private ArrayList<Integer> prepareElemsAtRow(int row, ArrayList<List<Integer>> result) {
        if (row == 1) {
            ArrayList<Integer> elem = new ArrayList<>();
            elem.add(1);
            return elem;
        }

        if (row == 2) {
            ArrayList<Integer> elem = new ArrayList<>();
            elem.add(1);
            elem.add(1);
            return elem;
        }

        if (row >= 3) {
            int previousIndex = row - 2;
            List<Integer> previous = result.get(previousIndex);
            ArrayList<Integer> elem = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) {
                    elem.add(1);
                } else {
                    elem.add(previous.get(i - 1) + previous.get(i));
                }
            }
            return elem;
        }

        return null;
    }
}
