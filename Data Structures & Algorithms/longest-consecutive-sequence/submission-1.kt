class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val memory = mutableSetOf<Int>()

        nums.forEach {
            memory.add(it)
        }

        nums.forEach {
            if (!memory.contains(it - 1)) {
                var temp = it
                var count = 0
                while (memory.contains(temp)) {
                    count++
                    temp += 1
                }
                result = max(result, count)
            }
        }

        return result
    }
}
