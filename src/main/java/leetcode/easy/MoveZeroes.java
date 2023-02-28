package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes tester = new MoveZeroes();
        tester.printArray(tester.moveZeroes(new int[]{0,1,0,3,12}));
        tester.printArray(tester.moveZeroes(new int[]{0, 0, 1}));
    }

    //새로운 배열을 쓸 수 없으므로, 기존 배열을 어떻게 활용해서 0을 옮길지 생각해봤다.
    //배열의 맨 처음 요소를 0 카운터로 쓰면 어떨까
    //맨 처음 요소 값을 임시 변수에 저장해두고 배열 요소를 흝으면서 0의 갯수를 찾는다
    //0이 나타나면, 0 카운터 값에 1을 추가한다. 이때 0을 지우고 싶은데 int[] 타입에서 이게 가능한지 모르겠다
    // arrayList로 변환하면 괜찮나?
    //배열 끝에 다다르면 0 카운터 값을 확인하고, 그 갯수만큼 배열 뒤에 0을 추가한다
    //마지막에는 처음 저장해놓았던 맨 처음 요소값을 0 카운터 값 대신 첫 요소에 넣는다
    public int[] moveZeroes(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num : nums) {
            result.add(num);
        }

        int firstElement = result.get(0);
        result.set(0, 0);
        if (firstElement == 0) {
            result.set(0, 1);
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 0) {
                result.set(0, result.get(0) + 1);
                result.remove(i);
            }
        }

        for (int i = 0; i < result.get(0); i++) {
            result.add(0);
        }
        result.remove(0);

        nums = result.stream().mapToInt(i -> i).toArray();
        return nums;
    }

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
