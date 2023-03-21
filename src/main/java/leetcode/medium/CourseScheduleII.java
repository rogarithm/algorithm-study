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
        int[] result = new int[numCourses];
        int idx = 0;
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[0]] += 1;
            //System.out.println("ind: " + indegrees[pre[0]]);
        }

        Map<Integer, Set<Integer>> prerequisiteLists = new HashMap<>();
        for (int[] pre : prerequisites) {
            prerequisiteLists.putIfAbsent(pre[0], new HashSet<>());
            prerequisiteLists.get(pre[0]).add(pre[1]);
            //System.out.println("pre list: ");
            //prerequisiteLists.get(pre[0]).forEach(e -> System.out.println(e + ", "));
        }

        Queue<Integer> preResult = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                preResult.add(i);
            }
        }

        while (!preResult.isEmpty()) {
            Integer currentCourse = preResult.poll();
            result[idx++] = currentCourse;
            System.out.println("currentCourse: " + currentCourse);

            if (prerequisiteLists.containsKey(currentCourse)) {
                for (int pre : prerequisiteLists.get(currentCourse)) {
                    indegrees[pre] -= 1;
                    if (indegrees[pre] == 0) {
                        preResult.add(pre);
                    }
                }
            }
        }

        return idx == numCourses ? result : new int[]{};
    }
}
