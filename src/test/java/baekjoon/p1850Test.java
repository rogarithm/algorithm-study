package baekjoon;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class p1850Test {

    @Test
    public void gcd() {
        assertThat(p1850.gcd(2, 4)).isEqualTo(2);
        assertThat(p1850.gcd(4, 2)).isEqualTo(2);
        assertThat(p1850.gcd(3, 5)).isEqualTo(1);
        assertThat(p1850.gcd(8, 20)).isEqualTo(2);
    }

}