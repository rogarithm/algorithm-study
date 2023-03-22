package jdk;

import java.util.LinkedList;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void pollReturnsFirstAddedElement() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        Assertions.assertThat(q.poll()).isEqualTo(1);
    }

}
