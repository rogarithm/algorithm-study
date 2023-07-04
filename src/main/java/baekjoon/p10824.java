package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class p10824 {

    public static void main(String[] args) throws IOException {
        String input = "1 2 3 4";
        BufferedReader br = new BufferedReader(new StringReader(input));
        String line = br.readLine();
        String[] nums = line.split(" +");
        String left = nums[0].concat(nums[1]);
        String right = nums[2].concat(nums[3]);
        System.out.println(Long.parseLong(left) + Long.parseLong(right));
    }
}