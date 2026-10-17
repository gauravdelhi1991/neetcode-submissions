class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        int prd = 1;
        for (int i = 0; i < nums.length; i++) {
            prd *= nums[i];
            leftToRight[i] = prd;
        }

        prd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prd *= nums[i];
            rightToLeft[i] = prd;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? 1: leftToRight[i - 1];
            int right = i == nums.length - 1 ? 1: rightToLeft[i + 1];
            result[i] = left * right;
        }

        return result;
    }
}  
