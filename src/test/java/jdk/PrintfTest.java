package jdk;

import java.util.IllegalFormatConversionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrintfTest {

    @Test
    public void testExnOccursWhenInputTypeNotMatched() {
        Assertions.assertThrows(IllegalFormatConversionException.class,
                () -> System.out.printf("%1.6f", 1));
    }
}
