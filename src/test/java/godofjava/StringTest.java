package godofjava;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void twoStringWithSameValueIsSameBecauseOfConstantPool() {
        String s1 = "check";
        String s2 = "check";
        Assertions.assertThat(s1 == s2).isTrue();
    }

    @Test
    public void twoStringWithSameValueIsEqual() {
        String s1 = "check";
        String s2 = "check";
        Assertions.assertThat(s1.equals(s2)).isTrue();
    }

    @Test
    public void testResionMatchMethodWithCase() {
        String s = "This is a text";
        String compare = "is";
        Assertions.assertThat(s.regionMatches(2, compare, 0, 2)).isTrue();
        Assertions.assertThat(s.regionMatches(5, compare, 0, 2)).isTrue();
    }

    @Test
    public void testResionMatchMethodIgnoreCase() {
        String s = "This is a text";
        String compare = "this";
        Assertions.assertThat(s.regionMatches(true, 0, compare, 0, 4)).isTrue();
    }

    @Test
    public void testSplit() {
        String s = "java technology";
        String delimiter = " ";
        String[] splitted = s.split(delimiter);

        Assertions.assertThat(splitted[0]).isEqualTo("java");
        Assertions.assertThat(splitted[1]).isEqualTo("technology");
    }

    @Test
    public void testTrim() {
        String[] trimThese = {"a ", " a", " a "};

        String[] result = new String[3];
        for (int i = 0; i < result.length; i++) {
            result[i] = trimThese[i].trim();
        }

        for (String trimmed : result) {
            Assertions.assertThat(trimmed.equals("a")).isTrue();
        }
    }
}
