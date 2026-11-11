class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int w1 = queue.poll();
            int w2 = queue.poll();

            if (w1 != w2) {
                queue.offer(w1 - w2);
            }
        }

        return queue.size() == 0 ? 0 : queue.peek();
    }
}
