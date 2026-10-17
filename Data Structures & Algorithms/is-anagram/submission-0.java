class Solution {
    public boolean isAnagram(String s, String t) {
        int[] memory = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            memory[chr - 'a']++;
            //System.out.println(String.format("value at chr=%c is %d", chr, memory[chr - 'a']));
        }

        for (int i = 0; i < t.length(); i++) {
            char chr = t.charAt(i);
            memory[chr - 'a']--;
            //System.out.println(String.format("value at chr=%c is %d", chr, memory[chr - 'a']));
        }

        for (int i = 0; i < 26; i++) {
            if (memory[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
