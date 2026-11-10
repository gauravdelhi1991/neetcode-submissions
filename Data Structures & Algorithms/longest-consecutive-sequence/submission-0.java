class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> memory = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            memory.add(num);
        }

        for (int num : nums) {
            if (!memory.contains(num - 1)) {
                int temp = num;
                while (memory.contains(temp)) {
                    temp++;
                }

                max = Math.max(max, temp - num);
            }
        }

        return max;
    }
}
