package jdk;


import java.util.Arrays;
import java.util.Comparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열 배열을 각 문자열 내 문자 갯수를 기준으로 정렬")
    public void sortInStringLength() {
        String[] strings = {"abc", "c", "ab"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String string : strings) {
            System.out.println(string);
        }
    }

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
    public void testConcatSubstringWithStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String word = "a.cd";
        int dotPosition = word.indexOf(".");

        sb.append(word.substring(0, dotPosition));
        sb.append("b");
        sb.append(word.substring(dotPosition + 1));

        Assertions.assertThat(sb.toString()).isEqualTo("abcd");
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
