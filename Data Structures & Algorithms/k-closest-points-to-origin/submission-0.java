class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> -1 * Double.compare(Math.sqrt(a[0]*a[0] + a[1]*a[1]), Math.sqrt(b[0]*b[0] + b[1]*b[1])));

        for (int[] point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else {
                int[] peek = queue.peek();
                if (Math.sqrt(peek[0]*peek[0] + peek[1]*peek[1]) > Math.sqrt(point[0]*point[0] + point[1]*point[1])) {
                    queue.poll();
                    queue.offer(point);
                }
            }
        }

        int[][] result = new int[k][2];
        int index = k - 1;
        while (!queue.isEmpty()) {
            result[index] = queue.poll();
            index--;
        }

        return result;

    }
}
