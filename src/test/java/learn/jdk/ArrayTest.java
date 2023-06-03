package learn.jdk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayTest {

    @Test
    public void make2DArray() {
        int[][] twoDim = {{1,2,3},{4,5,6}};

        int[][] twoDim2 = new int[2][3];
        twoDim2[0][0] = 1;
        twoDim2[0][1] = 2;
        twoDim2[0][2] = 3;
        twoDim2[1][0] = 4;
        twoDim2[1][1] = 5;
        twoDim2[1][2] = 6;
    }

    @Test
    public void getRowCount() {
        int[][] twoDim = {{1,2,3},{4,5,6}};
        Assertions.assertThat(twoDim.length).isEqualTo(2);
    }

    @Test
    public void getColumnCount() {
        int[][] twoDim = {{1,2,3},{4,5,6}};
        Assertions.assertThat(twoDim[0].length).isEqualTo(3);
        Assertions.assertThat(twoDim[1].length).isEqualTo(3);
    }



}