import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Combine duplicates (total damage per unique value)
        Map<Integer, Long> damageMap = new HashMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }

        // Step 2: Sort unique damage values
        List<Integer> values = new ArrayList<>(damageMap.keySet());
        Collections.sort(values);

        // Step 3: DP on sorted unique values
        int n = values.size();
        long[] dp = new long[n];
        dp[0] = damageMap.get(values.get(0));

        for (int i = 1; i < n; i++) {
            long take = damageMap.get(values.get(i));
            int j = i - 1;

            // Move backward to find the latest value that’s not in conflict
            while (j >= 0 && values.get(i) - values.get(j) <= 2) {
                j--;
            }

            // If we can take current value safely
            if (j >= 0) take += dp[j];

            // Skip or take
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }
}
