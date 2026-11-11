class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());

        for (int i = 0; i < nums.length; i++) {
            find(nums, i, List.of(nums[i]), result);
        }

        return result;
    }

    private void find(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);

        for (int i = index + 1; i < nums.length; i++) {
            List<Integer> subpath = new ArrayList<>(path);
            subpath.add(nums[i]);
            find(nums, i, subpath, result);
        }
    }
}
