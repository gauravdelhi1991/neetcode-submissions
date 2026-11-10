class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }

        return result;
        
    }
}
