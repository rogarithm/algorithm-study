package jdk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerTest {
    @Test
    public void sum() {
        Assertions.assertThat(Integer.sum(1, 2)).isEqualTo(3);
    }

}
