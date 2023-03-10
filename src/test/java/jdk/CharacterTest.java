package jdk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    @DisplayName("String을 char 배열로 변환할 수 있다")
    public void convertStringToCharArray() {
        String s = "string";
        char[] chars = s.toCharArray();
        assertThat(chars[0]).isEqualTo('s');
    }

    @Test
    @DisplayName("StringBuilder에 char 타입 값을 덧붙일 수 있다")
    public void appendCharToStringBuilder() {
        String s = "string";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        assertThat(sb.toString()).isEqualTo("string");
    }

    @Test
    @DisplayName("char 타입 범위 내라면 int 타입 값을 char 타입으로 변환해 쓸 수 있다")
    public void convertIntToCharOrViceVersa() {
        char smallA = 'a';
        int smallAInInt = 97;
        assertThat(smallA).isEqualTo((char)smallAInInt);
        assertThat((int)smallA).isEqualTo(smallAInInt);
    }

    @Test
    @DisplayName("char 타입 값을 비교할 때 정수 비교 연산자를 쓸 수 있다")
    public void comparingChars() {
        char c = 'c';
        char f = 'f';
        assertThat(c >= 'a' && c <= 'e').isTrue();
        assertThat(f >= 'a' && f <= 'e').isFalse();
    }

}
