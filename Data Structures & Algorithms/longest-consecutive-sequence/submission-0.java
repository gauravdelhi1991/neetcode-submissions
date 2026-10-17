class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> memory = new HashSet<>();

        for (int num : nums) {
            memory.add(num);
        }

        int result = 0;
        for (int num : nums) {
            int cur = 0;
            if (!memory.contains(num - 1)) {
                int temp = num;
                while (memory.contains(temp)) {
                    cur++;
                    temp++;
                }
                result = Math.max(result, cur);
            }
        }

        return result;
    }
}
