class Solution {
    public int trap(int[] height) {
        int[] lr = new int[height.length];
        int[] rl = new int[height.length];

        int max = 0;

        lr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lr[i] = Math.max(lr[i - 1], height[i]);
        }

        rl[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rl[i] = Math.max(rl[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            max += Math.min(lr[i], rl[i]) - height[i];
        }

        return max;
    }
}
