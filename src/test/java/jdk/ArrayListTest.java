package jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    @Test
    public void arrayListChangesSizeWhenAddElements() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assertions.assertEquals(0, arrayList.size());
        arrayList.add(1);
        arrayList.add(2);
        Assertions.assertEquals(2, arrayList.size());
    }

    @Test
    public void set() {
        //ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3));
        //ArrayList<Integer> test = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 4));
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 1));
        List<Integer> counts = new ArrayList<Integer>();
        int testSize = test.size();

        for (int i = 0; i < testSize; i++) {
            counts.add(i, 0);
        }

        for (int i = 0; i < testSize; i++) {
            int index = test.get(i);
            int currentCount = counts.get(index);

            System.out.println("index: " + index + ", current count: " + currentCount);
            counts.set(index, currentCount + 1); //index, value
        }

        for (int elem : counts) {
            System.out.println("E: " + elem);
        }
    }
}
