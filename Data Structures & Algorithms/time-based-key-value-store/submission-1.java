class TimeMap {

    static record Pair<T, U>(T first, U second){}

    Map<String, List<Pair<Integer, String>>> memory = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!memory.containsKey(key)) {
            memory.put(key, new ArrayList<>());
        }
        memory.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";

        List<Pair<Integer, String>> values = memory.getOrDefault(key, new ArrayList<>());

        int l = 0;
        int r = values.size() - 1;

        while (l <= r) {
            int mid = (l + r)/2;

            if (values.get(mid).first() <= timestamp) {
                result = values.get(mid).second();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
