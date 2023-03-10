package jdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {

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
            }
            else
                cache.put(nums[num], 1);
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
}
