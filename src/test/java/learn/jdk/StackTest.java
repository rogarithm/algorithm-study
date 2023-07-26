package learn.jdk;

import java.util.Arrays;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void sizeDecreaseWhenPop() {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1,2,3));
        int size = stack.size();
        Assertions.assertThat(stack.size()).isEqualTo(size);
        stack.pop();
        Assertions.assertThat(stack.size()).isLessThan(size);

    }

}