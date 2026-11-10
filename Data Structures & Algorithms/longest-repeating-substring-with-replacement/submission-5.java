class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;

        int maxFreq = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int freq = freqMap.getOrDefault(s.charAt(i), 0) + 1;
            maxFreq = Math.max(maxFreq, freq);
            freqMap.put(s.charAt(i), freq);

            //System.out.println(String.format("First %c, %d, %d", s.charAt(i), i, freq));

                while ((i - start + 1) - maxFreq > k) {
                    //System.out.println(String.format("Second %c, %d, %d", s.charAt(start), i, start));
                    freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) - 1);
                    start++;
                }


                max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
