class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
         
        Map<Character, Integer> tCount = new HashMap<>();

        for (char chr : t.toCharArray()) {
            tCount.put(chr, tCount.getOrDefault(chr, 0) + 1);
        }

        int needs = tCount.size();
        int min = Integer.MAX_VALUE;
        String result = "";
        int start = 0;

        Map<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            int count = sCount.getOrDefault(chr, 0) + 1;
            sCount.put(chr, count);
            //System.out.println(String.format("First %d %d %d %d", i, count, needs, tCount.getOrDefault(chr, 0)));
            if (tCount.containsKey(chr) && count == tCount.get(chr)) {
                needs--;
            }
            
            while (needs == 0) {
                //System.out.println(String.format("Third %d %d %d",needs, start, i));
                if (min > (i - start + 1)) {
                    min = i - start + 1;
                    result = s.substring(start, start + min);
                }
                count = sCount.get(s.charAt(start)) - 1;
                if (tCount.containsKey(s.charAt(start)) && count < tCount.get(s.charAt(start))) {
                    needs++;
                }
                sCount.put(s.charAt(start), count);
                start++;
            }
        }

        return result;
    }
}
