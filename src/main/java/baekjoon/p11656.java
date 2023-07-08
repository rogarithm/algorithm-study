package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p11656 {
    
    public static void main(String[] args) throws IOException {
        String input = "zbac";
        BufferedReader br = new BufferedReader(new StringReader(input));
        String word = br.readLine();
        List<String> results = new ArrayList<>();
        results.add(input);
        for (int i = 0; i < word.length() - 1; i++) {
            String substring;
            substring = word.substring(i + 1);
            results.add(substring);
        }
        Collections.sort(results);
        for (int i = 0; i < word.length(); i++) {
            System.out.println(results.get(i));
        }
    }

}