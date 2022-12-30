package jdk;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void testArrayListChangesSizeWhenAddElements() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assertions.assertEquals(0, arrayList.size());
        arrayList.add(1);
        arrayList.add(2);
        Assertions.assertEquals(2, arrayList.size());
    }

}
