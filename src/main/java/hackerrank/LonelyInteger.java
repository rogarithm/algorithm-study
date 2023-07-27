package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LonelyInteger {

    public static void main(String[] args) {
        System.out.println(
            LonelyInteger.lonelyinteger(new ArrayList<Integer>(Arrays.asList(1))) == 1);
        System.out.println(
            LonelyInteger.lonelyinteger(new ArrayList<Integer>(Arrays.asList(1, 1, 2))) == 2);
        System.out.println(
            LonelyInteger.lonelyinteger(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 3))) == 3);
        System.out.println(
            LonelyInteger.lonelyinteger(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 3, 2, 1)))
                == 4);

        System.out.println(
            LonelyInteger.lonelyinteger(new ArrayList<Integer>(Arrays.asList(1, 2, 2))) == 1);
    }

    public static int lonelyinteger(List<Integer> a) {
        if (a.size() == 1) {
            return a.get(0);
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        };
        a.sort(comparator);
        for (int i = 0; i < a.size() - 1; i = i + 2) {
            if (i + 1 > a.size() - 1) {
                break;
            }
            if (a.get(i) != a.get(i + 1)) {
                return a.get(i);
            }
        }
        return a.get(a.size() - 1);
    }


}