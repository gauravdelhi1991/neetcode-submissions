class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int count = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(adjMap, visited, i, -1);
                count++;
            }
        }

        return count;

    }

    private void dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> visited, int node, int parent) {
    if (visited.contains(node)) return;

    visited.add(node);

    for (Integer nei : adjMap.getOrDefault(node, new ArrayList<>())) {
        if (nei == parent) continue;

        dfs(adjMap, visited, nei, node);
    }
    }
}
