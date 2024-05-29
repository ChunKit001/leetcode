package org.example.a0_100;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
//
// Related Topics 数组 二分查找 分治 👍 7134 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        if (nums1Length > nums2Length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLeft = (nums1Length + nums2Length + 1) / 2;
        int left = 0;
        int right = nums1Length;

        while (left < right) {
            int numb1Index = left + (right - left + 1) / 2;
            int numb2Index = totalLeft - numb1Index;
            if (nums1[numb1Index - 1] <= nums2[numb2Index]) {
                left = numb1Index;
            } else {
                right = numb1Index - 1;
            }
        }

        int numb1Index = left;
        int numb2Index = totalLeft - numb1Index;
        int nums1LeftMax = numb1Index == 0 ? Integer.MIN_VALUE : nums1[numb1Index - 1];
        int nums2LeftMax = numb2Index == 0 ? Integer.MIN_VALUE : nums2[numb2Index - 1];
        if ((nums1Length + nums2Length) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            int nums1RightMin = numb1Index == nums1Length ? Integer.MAX_VALUE : nums1[numb1Index];
            int nums2RightMin = numb2Index == nums2Length ? Integer.MAX_VALUE : nums2[numb2Index];
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4});
        System.out.println(medianSortedArrays);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
