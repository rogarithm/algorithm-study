package jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void getOrDefault() {
        Map<String, Integer> cache = new HashMap<>();
        cache.put("a", 1);

        assertThat(cache.getOrDefault("a", 0)).isEqualTo(1);
        assertThat(cache.getOrDefault("unknown", 0)).isEqualTo(0);
    }

    @Test
    public void get() {
        int[] nums = {1};
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num = 0; num < nums.length; num++) {
            if (cache.get(nums[num]) != null) {
                cache.put(nums[num], 2);
            }
            cache.put(nums[num], 1);
        }

        Assertions.assertEquals(1, cache.get(1));
    }

    @Test
    public void putAfterPut() {
        int[] nums = {1, 1};
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num = 0; num < nums.length; num++) {
            if (cache.get(nums[num]) != null) {
                cache.put(nums[num], 2);
            } else {
                cache.put(nums[num], 1);
            }
        }

        Assertions.assertEquals(2, cache.get(1));
    }

    @Test
    public void merge() {
        int[] nums = {3, 3};
        Map<Integer, Integer> candidates = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            candidates.merge(current, 1, Integer::sum);
        }

        Assertions.assertEquals(2, candidates.get(3));
    }

    @Test
    public void containsKey() {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, null);
        System.out.println(cache.containsKey(1));
        System.out.println(cache.containsKey(2));
        System.out.println(cache.containsKey(3));
    }

    @Test
    public void putIfAbsent() {
        int[][] pres = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        Map<Integer, Set<Integer>> cache = new HashMap<>();
        for (int[] pre : pres) {
            cache.putIfAbsent(pre[1], new HashSet<>());
            cache.get(pre[1]).add(pre[0]);
        }

        for (int[] pre : pres) {
            System.out.println("{" + pre[0] + "," + pre[1] + "}: " + cache.get(pre[1]));
        }
    }

}
