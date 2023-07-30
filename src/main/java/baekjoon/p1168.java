package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class p1168 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder result = new StringBuilder().append('<');
        int index = k - 1;
        while (true) {
            result.append(nums.get(index));
            nums.remove(index);
            if (nums.isEmpty()) break;
            result.append(", ");
            index += k - 1;
            index %= nums.size();
            /*
                      1 2 3 4 5 6 7
            2
                      1 2 4 5 6 7
            4, 4%6=4
                      1 2 4 5 7
            6, 6%5=1
                      1 4 5 7
            3, 3%4=3
                      1 4 5
            5, 5%3=2
                      1 4
            4, 4%2=0
                      4
            2, 2%1=0
                      x
            */
        }
        result.append('>');

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}