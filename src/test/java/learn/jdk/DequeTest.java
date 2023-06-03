package learn.jdk;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Deque;
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
}