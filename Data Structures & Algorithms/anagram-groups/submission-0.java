class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memory = new HashMap<>();

        for (String str : strs) {
            char[] chr = str.toCharArray();
            Arrays.sort(chr);

            if (!memory.containsKey(String.valueOf(chr))) {
                memory.put(String.valueOf(chr), new ArrayList<>());
            }

            memory.get(String.valueOf(chr)).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> res : memory.values()) {
            result.add(res);
        }

        return result;
    }
}
