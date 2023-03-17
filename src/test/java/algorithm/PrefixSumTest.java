package algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSumTest {

    @Test
    public void sumAlwaysIncrease() {
        int[] source = new int[]{1, 2, 3};
        int[] prefixSum = new int[source.length];

        int currentSum = 0;
        for (int i = 0; i < source.length; i++) {
            currentSum = currentSum + source[i];
            prefixSum[i] = currentSum;
        }

        StringBuilder result = new StringBuilder();
        for (int sum : prefixSum) {
            result.append(sum);
            result.append(" ");
        }
        Assertions.assertThat(result.toString()).isEqualTo("1 3 6 ");
    }

    @Test
    public void sumIncreaseAtTimes() {
        int[] source = new int[]{1, 0, 0, 2};
        int[] prefixSum = new int[source.length];

        int currentSum = 0;
        for (int i = 0; i < source.length; i++) {
            currentSum = currentSum + source[i];
            prefixSum[i] = currentSum;
        }

        StringBuilder result = new StringBuilder();
        for (int sum : prefixSum) {
            result.append(sum);
            result.append(" ");
        }
        Assertions.assertThat(result.toString()).isEqualTo("1 1 1 3 ");
    }

    @Test
    public void sumIncreaseOrDecrease() {
        int[] source = new int[]{1, 1, -1, 2};
        int[] prefixSum = new int[source.length];

        int currentSum = 0;
        for (int i = 0; i < source.length; i++) {
            currentSum = currentSum + source[i];
            prefixSum[i] = currentSum;
        }

        StringBuilder result = new StringBuilder();
        for (int sum : prefixSum) {
            result.append(sum);
            result.append(" ");
        }
        Assertions.assertThat(result.toString()).isEqualTo("1 2 1 3 ");
    }
}
