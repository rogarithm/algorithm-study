//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Example 1:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//
//Example 2:
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(2) == 2);
        System.out.println(cs.climbStairs(3) == 3);
    }

    public int climbStairs(int n) {
        // 처음은 무조건 1이나 2. 그 다음엔 가능하냐 불가능하냐에 따라서 1, 2 둘 다 될수도, 1이나 2 중 하나만 될 수도, 아무것도 안될 수도 있다.
        // 아무것도 안될 가능성을 미리 판단할 수 있는 기준이 있을까?

        // 가능한 모든 경로를 확인해본다.
        // 지금 체크하는 경로가 유효하면 결과에 1을 더한다. 유효한지 어떻게 확인하나? n이 0이 되면 유효한 경로다.
        int result = 0;

        if (n == 0 || n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
