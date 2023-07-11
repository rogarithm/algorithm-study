package learn.jdk;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DequeTest {

    Deque<Integer> deque;
    int[] test1 = {1, 2, 3, 4, 5};

    @BeforeEach
    public void setUp() {
        deque = new ArrayDeque<>();
        for (int i : test1) {
            deque.add(i);
        }
    }

    @Test
    public void popEquivalent() {
        assertThat(deque.pop()).isEqualTo(test1[0]);
        assertThat(deque.removeFirst()).isEqualTo(test1[1]);
    }

    @Test
    public void pushEquivalent() {
        deque.push(0);
        assertThat(deque.removeFirst()).isEqualTo(0);
        deque.addFirst(0);
        assertThat(deque.removeFirst()).isEqualTo(0);
    }

    @Test
    public void peekEquivalent() {
        assertThat(deque.peek()).isEqualTo(deque.getFirst());
    }

    @Test
    public void canRotateIndex() {
        Iterator<Integer> iterator = deque.iterator();
        for (int i=0; i<deque.size(); i++) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
                System.out.println("not yet...");
            }
        }
        System.out.println("is this equal to first index?");
        Iterator<Integer> iterator2 = deque.iterator();
        System.out.println(iterator2.next());
    }
}