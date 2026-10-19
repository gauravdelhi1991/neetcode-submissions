class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> memory = new HashMap<>();
        int result = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (memory.containsKey(s.charAt(i)) && memory.get(s.charAt(i)) >= start) {
                start = memory.get(s.charAt(i)) + 1;
            }
            result = Math.max(result, i - start + 1);
            memory.put(s.charAt(i), i);
        }

        return result;
    }
}
