    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
        val memory = mutableMapOf<Int, Int>();

        nums.forEachIndexed { index, num ->
            val complement = target - num
            if (memory.containsKey(complement)) {
                return intArrayOf(memory[complement]!!, index)
            }
            memory[num] = index
        }

        return intArrayOf()
        }
    }
