package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopologicalSort {

    @Test
    public void getAllNodes() {
        int[][] t = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        //그래프 각 요소마다 첫번째 값만 확인하면서 순회하면 indegree가 0인 요소는 볼 수 없다
        //set에 graph 내 각 요소의 첫번째, 두번째 값을 넣으면 모든 node를 넣을 수 있을 것 같다
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                nodes.add(t[i][j]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int node : nodes) {
            result.append(node);
            result.append(", ");
        }
        result.delete(10, 12);

        Assertions.assertThat(result.toString()).isEqualTo("0, 1, 2, 3");
    }

    @Test
    public void storeIndegrees() {
        int[][] t = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        caseOne(t);
    }

    public int[] caseOne(int[][] graph) {
        //그래프 각 요소마다 첫번째 값만 확인하면서 순회하면 indegree가 0인 요소는 볼 수 없다
        //set에 graph 내 각 요소의 첫번째, 두번째 값을 넣으면 모든 node를 넣을 수 있을 것 같다
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                nodes.add(graph[i][j]);
            }
        }

        //nodes 안에 있는 node마다 indegree 값을 저장하자
        Map<Integer, Integer> indegrees = new HashMap<>();
        //graph 안 요소 중 indegree가 없는 요소도 포함하기 위해 먼저 nodes를 순회하면서 node마다 기본값을 설정한다
        for (int node : nodes) {
            indegrees.put(node, 0);
        }

        //graph 안 요소를 순회하면서 indegree 값을 업데이트한다
        for (int[] elem : graph) {
            indegrees.put(elem[0], indegrees.getOrDefault(elem[0], 0) + 1);
        }

        indegrees.forEach((k, v) -> System.out.println(k + " " + v));

        int[] result = new int[graph.length];
        //indegree 값이 0인 node를 검색해서 result에 넣고나면 나머지 node 중 이 node에 의존하던 것의 indegree 값을
        //1씩 빼고 다시 indegree 값이 0인 node를 검색하는 것을 반복해야 한다
        //indegrees 해시맵 안에는 다른 node와 연결 정보가 들어있지 않은데 어떻게 검색해야 하지? 입력받은 graph에서 검색하나?

        return result;
    }

}
