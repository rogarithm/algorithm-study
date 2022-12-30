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
        System.out.println(tester.generate(3));
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

        /* 0 1 */
        /* 0 1=2.0+2.1 2 */
        /* 0 1=3.0+3.1 2=3.1+3.2 3 */
        /* 바로 위 행의 계산 결과를 어떻게 가져오지? */
        if (row == 3) {
            int previousIndex = row - 2;
            List<Integer> previous = result.get(previousIndex);
            ArrayList<Integer> elem = new ArrayList<>();
            elem.add(1);
            elem.add(previous.get(0) + previous.get(1));
            elem.add(1);
            return elem;
        }

        return null;
    }
}
