package jdk;

import org.junit.jupiter.api.Test;

public class StringBuilderTest {

    @Test
    public void lengthOfEmptyStringBuilder() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.length());
    }

    @Test
    public void storeOtherStringBuilder() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb2.append("try this");
        sb1 = sb2;
        System.out.println(sb1.toString());
    }

}
