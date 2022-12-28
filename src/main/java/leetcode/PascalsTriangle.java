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
        /* numRow는 해당 행의 요소 갯수와도 일치한다 */
        /* 각 행에 들어갈 array list 생성 시 안에 넣을 수 있는 요소 갯수도 정해야 할까? */
        /* 이전 행의 인덱스를 기준으로 새로 만들려는 행의 요소 값을 계산할 수 있을까? */

        ArrayList<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return null;
        }

        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> elemsInRowI = prepareElementsInRow(i);
            result.add(elemsInRowI);
        }

        return result;
    }

    private ArrayList<Integer> prepareElementsInRow(int rowNumber) {
        if (rowNumber == 1) {
            ArrayList<Integer> elem = new ArrayList<>(rowNumber);
            elem.add(1);
            return elem;
        }

        if (rowNumber == 2) {
            ArrayList<Integer> elem = new ArrayList<>(rowNumber);
            elem.add(1);
            elem.add(1);
            return elem;
        }

        return null;
    }
}
