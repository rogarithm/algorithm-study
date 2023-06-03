package learn.jdk;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void storedElementsOfArrayDequeAreNotSorted() {
        ArrayDeque<Integer> aq = new ArrayDeque<>();
        List<Integer> integers = Arrays.asList(3, 10, 8, 9);

        for (Integer integer : integers) {
            aq.add(integer);
        }

        for (int i = 0; i < aq.size(); i++) {
            Assertions.assertThat(aq.poll()).isEqualTo(integers.get(i));
        }
    }

    @Test
    public void priorityQueueStoreElementsInAscendingOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> integers = Arrays.asList(3, 10, 8, 9);

        for (Integer integer : integers) {
            pq.add(integer);
        }

        for (int i = 0; i < 2; i++) {
            Integer earlier = pq.poll();
            Integer later = pq.poll();
            System.out.println("earlier: " + earlier);
            System.out.println("later: " + later);
            Assertions.assertThat(earlier < later).isTrue();
        }
    }
}