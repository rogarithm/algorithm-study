package learn.jdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListIteratorTest {

    List<Character> chars;
    ListIterator<Character> iter;

    @BeforeEach
    public void setUp() {
        String s = "abcde";

        chars = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            chars.add(c);
        }

        iter = chars.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
    }

    @Test
    public void nextReturnsValueAndMovesCursorToRight() {

        //after assertion...
        assertThrows(NoSuchElementException.class, () -> iter.next()); //e|
        iter.previous(); //d|e
        assertThat(iter.next()).isEqualTo('e'); //de|
        assertThat(iter.previous()).isEqualTo('e'); //d|e
    }

    @Test
    public void removeLastWithoutPrevious() {

        assertThrows(NoSuchElementException.class, () -> iter.next());
        iter.previous();

        iter.remove();

        assertThrows(NoSuchElementException.class, () -> iter.next());
        iter.previous();

        assertThat(iter.previous()).isEqualTo('c');
        StringBuilder result = new StringBuilder();
        for (Character c : chars) {
            result.append(c);
        }
        assertThat(result.toString()).isEqualTo("abcd");
    }

    @Test
    public void removeLastAfterPrevious() {

        assertThrows(NoSuchElementException.class, () -> iter.next());
        iter.previous();

        assertThat(iter.next()).isEqualTo('e');
        iter.previous();

        iter.previous();

        assertThat(iter.next()).isEqualTo('d');
        iter.previous();

        iter.remove();

        assertThat(iter.next()).isEqualTo('e');
        StringBuilder result = new StringBuilder();
        for (Character c : chars) {
            result.append(c);
        }
        assertThat(result.toString()).isEqualTo("abce");
    }
}