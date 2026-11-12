class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int len = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (dp[i][i+1]) {
                start = i;
                len=2;
            }
        }

        for (int i = 3; i <=n ; i++) {
            for (int j = 0; j <= n - i; j++) {
                dp[j][j+i-1] = s.charAt(j) == s.charAt(j+i-1) && dp[j+1][j+i-2];
                if (dp[j][j+i-1]) {
                    start = j;
                    len=i;
                }
            }
        }


        return s.substring(start, start+len);
    }
}
