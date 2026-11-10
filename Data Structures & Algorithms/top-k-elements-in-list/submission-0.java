class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMem = new HashMap<>();

        for (int num : nums) {
            countMem.put(num, countMem.getOrDefault(num, 0) +1);
        }

        Map<Integer, List<Integer>> freqMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : countMem.entrySet()) {
            if (!freqMap.containsKey(entry.getValue())) {
                freqMap.put(entry.getValue(), new ArrayList<>());
            }

            freqMap.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (Map.Entry<Integer, List<Integer>> entry : freqMap.entrySet()) {
            if (k < entry.getValue().size()) {
                int subIndex = 0;
                while (k > 0) {
                    result[index] = entry.getValue().get(subIndex);
                    index++;
                    subIndex++;
                }
                break;
            } else {
                for (Integer num : entry.getValue()) {
                    result[index] = num;
                    index++;
                }
                k = k - entry.getValue().size();
            }
        }

        return result;
    }
}
