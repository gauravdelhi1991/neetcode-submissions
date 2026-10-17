class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memory = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (memory.containsKey(target - num)) {
                int[] result = new int[]{memory.get(target -num), i};
                return result;
            }
            memory.put(num, i);
        }

        return new int[2];
    }
}
