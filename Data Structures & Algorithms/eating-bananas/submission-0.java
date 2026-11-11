class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;

            int time = timetaken(piles, mid);

            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
        
    }

    private int timetaken(int[] piles, int rate) {
        int time = 0;

        for (int pile : piles) {
            time += (pile/rate) + (pile%rate > 0 ? 1 : 0);
        }

        return time;
    }
}
