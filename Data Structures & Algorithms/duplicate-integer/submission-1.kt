class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.distinct().size != nums.size;
    }
}
