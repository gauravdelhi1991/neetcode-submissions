class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int max = 0;
        int maxF = 0;
        Map<Character, Integer> memory = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //System.out.println(String.format("%d", memory.getOrDefault(s.charAt(i), -2)));
            memory.put(s.charAt(i), memory.getOrDefault(s.charAt(i), 0) + 1);
            maxF = Math.max(maxF, memory.get(s.charAt(i)));
            //System.out.println(String.format("%d %d %d %c %d %d", i, start, maxF, s.charAt(i), maxF, memory.get(s.charAt(i))));
            if (i - start + 1 - maxF <= k) {
                max = Math.max(max, i - start + 1);
            } else {
                while (i - start + 1 - maxF > k) {
                    //System.out.println(String.format("%c %d, %d", s.charAt(start));
                    memory.put(s.charAt(start), memory.getOrDefault(s.charAt(start), 0) - 1);
                    start++;
                }
            }
        }

        

        return max;
    }
}
