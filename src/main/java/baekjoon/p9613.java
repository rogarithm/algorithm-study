package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class p9613 {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("1\n"
                + "4 2 4 6 8"));
        int count = Integer.parseInt(br.readLine());
        List<Integer> elems = new ArrayList<>();
        List<List<Pair>> combinations = new ArrayList<>();

        for (int i=0; i<count; i++) {
            String[] testCase = br.readLine().split(" ");
            int nums = Integer.parseInt(testCase[0]);
            for (int j=0; j<nums; j++) {
                elems.add(Integer.parseInt(testCase[j+1]));
            }

            for (int k=0; k<nums; k++) {
                List<Pair> combination = new ArrayList<>();
                Integer left = elems.get(k);
                for (int l=k+1; l<nums; l++) {
                    Integer right = elems.get(l);
                    combination.add(new Pair(left, right));
                }
                combinations.add(combination);
            }
        }

        int c = 0;
        for (List<Pair> comb : combinations) {
            System.out.print(c + ": ");
            for (Pair pair : comb) {
                System.out.print(pair + ", ");
            }
            System.out.println();
            c++;
        }
    }

    private static class Pair {

        int left;
        int right;

        public Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + left + "," + right + ")";
        }
    }

}