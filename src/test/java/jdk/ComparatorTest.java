package jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparatorTest {

    @Test
    public void testSortArrayWithComparator() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 3, 1, 5, 4));
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
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
