package jdk;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void incrementStringWithIntegerContent() {
        Integer sInInt = Integer.valueOf("1");
        sInInt = sInInt + 1;
        Assertions.assertThat(sInInt.toString()).isEqualTo("2");
    }
    @Test
    public void substringSecondArgIsExclusive() {
        String word = "a.cd";
        int dotPosition = word.indexOf(".");
        Assertions.assertThat(word.substring(0, dotPosition)).isEqualTo("a");
    }

    @Test
    public void substringSecondArgNoNeedIfItIsEndOfString() {
        String word = "abcd";
        Assertions.assertThat(word.substring(1, word.length())).isEqualTo(word.substring(1));
    }

    @Test
    public void concatSubstring() {
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
    public void concatSubstringWithStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String word = "a.cd";
        int dotPosition = word.indexOf(".");

        sb.append(word.substring(0, dotPosition));
        sb.append("b");
        sb.append(word.substring(dotPosition + 1));

        Assertions.assertThat(sb.toString()).isEqualTo("abcd");
    }

    @Test
    public void indexOfFail() {
        String word = "abcd";
        Assertions.assertThat(word.indexOf(".")).isEqualTo(-1);
    }

    @Test
    public void indexOfSuccess() {
        String word = "a.cd";
        Assertions.assertThat(word.indexOf(".")).isEqualTo(1);
    }

    @Test
    public void containsSuccess() {
        Assertions.assertThat(".ad".contains(".")).isEqualTo(true);
        Assertions.assertThat("a.d".contains(".")).isEqualTo(true);
    }

    @Test
    public void containsFail() {
        Assertions.assertThat("bad".contains(".")).isEqualTo(false);
    }

}
