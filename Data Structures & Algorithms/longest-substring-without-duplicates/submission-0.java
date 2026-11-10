class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> memory = new HashMap<>();
        int start = 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (memory.containsKey(s.charAt(i)) && memory.get(s.charAt(i)) >= start) {
            
                start = memory.get(s.charAt(i)) + 1;
            }
                max = Math.max(max, i - start + 1);
                memory.put(s.charAt(i), i);
        }

        return max;
    }
}
