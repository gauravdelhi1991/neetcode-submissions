class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memory = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (memory.containsKey(target - nums[i])) {
                return new int[]{memory.get(target - nums[i]), i};
            }
            memory.put(nums[i], i);
        }

        return new int[0];
    }
}
