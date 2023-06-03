package learn.jdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IteratorTest {

    Set<String> strings;
    int counter;

    @BeforeEach
    public void setUp() {
        strings = new HashSet<>();
        counter = 0;
    }

    @AfterEach
    public void tearDown() {
        strings.clear();
        counter = 0;
    }

    @Test
    public void iterateZeroElemenet() {

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }

        Assertions.assertThat(counter).isEqualTo(0);
    }

    @Test
    public void iterateOneElemenet() {
        strings.add("a");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }

        Assertions.assertThat(counter).isEqualTo(1);
    }

    @Test
    public void iterateTwoElemenet() {
        strings.add("a");
        strings.add("b");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }

        Assertions.assertThat(counter).isEqualTo(2);
    }

}