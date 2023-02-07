package jdk;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testIncrementStringWithIntegerContent() {
        Integer sInInt = Integer.valueOf("1");
        sInInt = sInInt + 1;
        Assertions.assertThat(sInInt.toString()).isEqualTo("2");
    }
    @Test
    public void testSubstringSecondArgIsExclusive() {
        String word = "a.cd";
        int dotPosition = word.indexOf(".");
        Assertions.assertThat(word.substring(0, dotPosition)).isEqualTo("a");
    }

    @Test
    public void testSubstringSecondArgNoNeedIfItIsEndOfString() {
        String word = "abcd";
        Assertions.assertThat(word.substring(1, word.length())).isEqualTo(word.substring(1));
    }

    @Test
    public void testConcatSubstring() {
        String word = "a.cd";
        int dotPosition = word.indexOf(".");
        String character = "b";
        Assertions.assertThat(
                word.substring(0, dotPosition)
                        + character
                        + word.substring(dotPosition + 1))
                .isEqualTo("abcd");
    }

    @Test
    public void testIndexOfFail() {
        String word = "abcd";
        Assertions.assertThat(word.indexOf(".")).isEqualTo(-1);
    }

    @Test
    public void testIndexOfSuccess() {
        String word = "a.cd";
        Assertions.assertThat(word.indexOf(".")).isEqualTo(1);
    }

    @Test
    public void testContainsSuccess() {
        Assertions.assertThat(".ad".contains(".")).isEqualTo(true);
        Assertions.assertThat("a.d".contains(".")).isEqualTo(true);
    }

    @Test
    public void testContainsFail() {
        Assertions.assertThat("bad".contains(".")).isEqualTo(false);
    }

}
