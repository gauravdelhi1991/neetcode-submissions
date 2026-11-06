class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] memory = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            memory[s1.charAt(i) - 'a']++;
        }

        int[] mem = new int[26];
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (memory[s2.charAt(i) - 'a'] > 0) {
                System.out.println(String.format("First %c", s2.charAt(i)));
                int j = 0;
                for (; j < s1.length(); j++) {
                    mem[s2.charAt(i+j) - 'a']++;
                    if (mem[s2.charAt(i+j) - 'a'] > memory[s2.charAt(i+j) - 'a']) {
                        System.out.println(String.format("Second %c", s2.charAt(i)));
                        break;
                    }
                }


                System.out.println(String.format("Third %d", j));
                if (j < s1.length()) {
                    for (int z = 0; z <= j; z++) {
                        mem[s2.charAt(i+z) - 'a'] = 0;
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
