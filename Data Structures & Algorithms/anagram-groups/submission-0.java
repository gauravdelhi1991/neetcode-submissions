class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memory = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            memory.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> value : memory.values()) {
            result.add(value);
        }

        return result;
    }
}
