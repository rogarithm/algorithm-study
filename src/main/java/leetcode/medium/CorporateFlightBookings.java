package leetcode.medium;

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] cache = new int[n];
        for (int[] booking : bookings) {
            cache[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                cache[booking[1]] -= booking[2];
        }

        int[] result = new int[n];
        int currentSum = 0;
        for (int i = 0; i < result.length; i++) {
            currentSum = currentSum + cache[i];
            result[i] = currentSum;
        }

        return result;
    }
}
