class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[1], nums[0]);

        return Math.max(dfs(nums, 0, n - 2), dfs(nums, 1, n-1));
    }

    private int dfs(int[] nums, int start, int end) {
        int n = end-start+1;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i + start -1]+dp[i-2]);
        }

        return dp[n];
    }
}
