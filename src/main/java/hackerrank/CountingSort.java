package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    // 빈도수 저장할 배열 크기와 입력 배열 크기가 달라야 한다는 점을 생각하면, 두 반복문에 들어갈 경계값은 각각 달라야 한다.

    public static List<Integer> countingSort(List<Integer> arr) {

        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) { // 빈도수를 저장할 배열 크기는 100으로 고정된다
            counts.add(i, 0);
        }

        for (int i = 0; i < arr.size(); i++) { // 입력 배열은 100 이상 10^6 이하 크기다
            int index = arr.get(i); // 입력 배열에서 가져온 값이 빈도수 배열의 인덱스가 된다
            int currentCount = counts.get(index);

            counts.set(index, currentCount + 1); //매개변수 역할은 차례대로 index, value다.
        }

        return counts;

    }
}
