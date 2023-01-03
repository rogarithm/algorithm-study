package jdk;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    public void testGet() {
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
    public void testPutAfterPut() {
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
}
