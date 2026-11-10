class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] memory = new int[26];

        for (int i = 0; i < s.length(); i++) {
            memory[s.charAt(i) - 'a']++;
            memory[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (memory[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
