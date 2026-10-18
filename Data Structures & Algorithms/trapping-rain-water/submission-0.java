class Solution {
    public int trap(int[] height) {
        int[] ltor = new int[height.length];
        int[] rtol = new int[height.length];

        int max = height[0];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            ltor[i] = max;
        }

        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rtol[i] = max;
        }

        max = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int cur = Math.min(ltor[i], rtol[i]) - height[i];
            if (cur > 0) {
                max += cur;
            }
        }

        return max;
        
    }
}
