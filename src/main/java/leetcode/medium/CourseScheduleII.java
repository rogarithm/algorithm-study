package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        CourseScheduleII tester = new CourseScheduleII();
        int[] result = tester.findOrder(4, t);
        //for (int i : result) {
        //    System.out.println(i);
        //}
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[0]] += 1; //각 pre는 수업과 그 수업의 선행수업으로 구성. 선행수업이 하나 있을 때마다 indegree도 1 증가
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new HashSet<>()); //선행수업을 키로 하고, 이 수업을 들어야 수강할 수 있는 수업 목록을 값으로 한다
            map.get(pre[0]).add(pre[1]);
            //System.out.println("pre list: ");
            //prerequisiteLists.get(pre[0]).forEach(e -> System.out.println(e + ", "));
        }

        Queue<Integer> zeroIndegreeCourses = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                zeroIndegreeCourses.add(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!zeroIndegreeCourses.isEmpty()) {
            Integer currentZeroIndegreeCourse = zeroIndegreeCourses.poll();
            result[idx++] = currentZeroIndegreeCourse;
            //System.out.println("currentCourse: " + currentCourse);

            if (map.containsKey(currentZeroIndegreeCourse)) {
                //이 수업을 선행수업으로 하는 수업들의 indegree를 1만큼 다시 빼야 한다
                for (int pre : map.get(currentZeroIndegreeCourse)) {
                    indegrees[pre] -= 1;
                    if (indegrees[pre] == 0) {
                        zeroIndegreeCourses.add(pre);
                    }
                }
            }
        }

        return idx == numCourses ? result : new int[]{};
    }
}
