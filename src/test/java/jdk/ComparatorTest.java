package jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparatorTest {

    @Test
    @DisplayName("Arrays에 내장된 sort 메서드로도 정렬할 수 있다")
    public void sortArrayWithBuiltinMethod() {
        int[] ints = {4, 3, 2, 1};
        Arrays.sort(ints);
        assertThat(ints[0]).isEqualTo(1);
    }

    @Test
    public void testSortStringArray() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("a", "ab", "abc"));
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                return o2.length() - o1.length(); // 더 긴 문자열이 앞으로 온다
            }
        };
        arrayList.sort(comparator);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }


    @Test
    public void sortArrayWithComparator() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 4));
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) { // 더 작은 숫자가 앞으로 온다
                if (i1 == i2) {
                    return 0;
                } else if (i1 < i2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        arrayList.sort(comparator);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            assertThat(arrayList.get(i) < arrayList.get(i++));
        }
    }
}
