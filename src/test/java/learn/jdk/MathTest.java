package learn.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    public void floor() {
        assertThat((int) Math.floor(1.2f)).isEqualTo(1);
        assertThat((int) Math.floor(1.9f)).isEqualTo(1);
    }

    @Test
    public void ceiling() {
        assertThat(Math.ceil(1.2f)).isEqualTo(2f);
        assertThat(Math.ceil(1.9f)).isEqualTo(2f);
    }
}