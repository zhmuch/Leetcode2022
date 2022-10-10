package com.example.kotlinplayground.google

/**
 * 004
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
class MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return mergeAndGet(nums1, nums2)
    }

    /**
     * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
     *
     * Recursively solve the problem.
     *
     * find k-th number in an array
     * ->
     * find k-th number in two sorted array
     * ->
     * consider odd and even number cases
     */
    fun findMedianOfTwoSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size

        val medianSmaller = (size1 + size2 + 1) / 2
        val medianLarger = (size1 + size2 + 2) / 2
        return (findKthOfTwoSortedArray(nums1, 0, nums2, 0, medianSmaller) +
                findKthOfTwoSortedArray(nums1, 0, nums2, 0, medianLarger)) / 2
    }

    private fun findKthOfTwoSortedArray(
        nums1: IntArray, index1: Int,
        nums2: IntArray, index2: Int,
        k: Int
    ): Double {
        //  nums1 is used up
        if (index1 == nums1.size) {
            return nums2[index2 + k - 1].toDouble()
        }
        //  nums2 is used up
        if (index2 == nums2.size) {
            return nums1[index1 + k - 1].toDouble()
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]).toDouble()
        }

        /**
         * The key point of this problem is to ignore half part of A and B each step recursively
         * by comparing the median of remaining A and B:
         * if (aMid < bMid) Keep [aRight + bLeft]
         * else Keep [bRight + aLeft]
         */
        var nums1Mid = Int.MAX_VALUE
        var nums2Mid = Int.MAX_VALUE
        val kMid = k / 2

        // the k/2 th element
        if (index1 + kMid - 1 < nums1.size) {
            nums1Mid = nums1[index1 + kMid - 1]
        }
        if (index2 + kMid - 1 < nums2.size) {
            nums2Mid = nums2[index2 + kMid - 1]
        }

        return if (nums1Mid < nums2Mid) {
            findKthOfTwoSortedArray(nums1, index1 + kMid, nums2, index2, k - kMid)
        } else {
            findKthOfTwoSortedArray(nums1, index1, nums2, index2 + kMid, k - kMid)
        }
    }

    /**
     * Equivalent to: find k-th number in an array
     *
     * step0: determine k value
     * step1: get a pivot number
     * step2: count the # of number that are less than the pivot
     * step3: repeat 1 and 2, until # match the k value
     */
//    fun divideAndConquer(nums1: IntArray, nums2: IntArray): Double {
//        val size1 = nums1.size
//        val size2 = nums2.size
//
//        var index1 = 0
//        var index2 = 0
//
//        while () {
//            val remain1 = size1 - index1
//            val remain2 = size2 - index2
//            if (remain1 > remain2)
//        }
//    }

    /**
     * Naive merge and get median
     */
    fun mergeAndGet(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = mergeTwoSortedArrays(nums1, nums2)
        val size = mergedArray.size
        return if (size % 2 == 0) {
            (mergedArray[size / 2 - 1].toDouble() + mergedArray[size / 2].toDouble()) / 2
        } else {
            mergedArray[size / 2].toDouble()
        }
    }

    private fun mergeTwoSortedArrays(nums1: IntArray, nums2: IntArray): IntArray {
        val size1 = nums1.size
        val size2 = nums2.size

        var index1 = 0
        var index2 = 0
        var mergedIndex = 0
        val mergedArray = IntArray(size1 + size2)
        while (index1 < size1 || index2 < size2) {
            if (index1 == size1) {
                // nums1 is used up
                mergedArray[mergedIndex] = nums2[index2]
                index2++
                mergedIndex++
            } else if (index2 == size2) {
                // nums2 is used up
                mergedArray[mergedIndex] = nums1[index1]
                index1++
                mergedIndex++
            } else {
                // put the smaller element of two arrays into the new merged array
                val num1 = nums1[index1]
                val num2 = nums2[index2]
                if (num1 < num2) {
                    mergedArray[mergedIndex] = num1
                    index1++
                    mergedIndex++
                } else {
                    mergedArray[mergedIndex] = num2
                    index2++
                    mergedIndex++
                }
            }
        }
        return mergedArray
    }
}
