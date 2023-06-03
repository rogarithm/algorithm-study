package learn.jdk;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OptionalTest {

    @Test
    @DisplayName("null일 수 있는 값을 Optional로 표현")
    public void representNullableValue() {
        Optional<Object> nullValue = Optional.ofNullable(null);
        Assertions.assertThat(nullValue).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("null일 리 없는 값을 Optional로 표현")
    public void representNeverNullableValue() {
        Optional<String> neverNullable = Optional.of("neverNullable");
        Assertions.assertThat(neverNullable.isPresent()).isTrue();
    }

    @Test
    @DisplayName("두 변수 모두 Optional 타입이고 값이 같아야 equals 결과가 true")
    public void equalsOfOptionalReturnsTrue() {
        Optional<String> s1 = Optional.of("s");
        Optional<String> s2 = Optional.of("s");

        Assertions.assertThat(s1.equals(s2)).isTrue();
    }

    @Test
    @DisplayName("두 변수 중 하나가 Optional 타입이 아니면 값이 같아도 equals 결과가 false")
    public void equalsOfOptionalReturnsFalse() {
        Optional<String> s1 = Optional.of("s");
        String s2 = "s";

        Assertions.assertThat(s1.equals(s2)).isFalse();

    }
}