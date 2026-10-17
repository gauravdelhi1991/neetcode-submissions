class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<>();
        
        for(int num : nums) {
            memory.put(num, memory.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : memory.entrySet()) {
            resultMap.computeIfAbsent(entry.getValue(), t -> new ArrayList<>()).add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

    for (List<Integer> keys : resultMap.values()) {
        for (Integer key : keys) {
            result[index] = key;
            index++;
            if (index == k) {
                break;
            }
        }
        
            if (index == k) {
                break;
            }
    }

    return result;
    }
}
