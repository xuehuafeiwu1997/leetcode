package leetCodeTop100;

/**
 * 寻找两个正序数组的中位数
 *
 * @author xmy
 * @date 2022/6/15 10:51 下午
 */
public class SolutionForth {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double medianSortedArrays = findMedianSortedArraysSecond(nums1, nums2);
        System.out.println(medianSortedArrays);

    }

    //1.暴力解法 归并排序，但是时间复杂度方面并不符合要求 最后的cout代表的是数组的下标识，所以count++刚好是数组的长度
    //奇数和偶数的长度可以优化的
    //时间复杂度：遍历全部数组O（m+n）
    //空间复杂度：开辟了一个新的数组，保存合并后的两个数组O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
            } else {
                return nums1[n /2];
            }
        }

        //归并逻辑
        int count = 0;
        int i = 0;
        int j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

//        if (count % 2 == 0) {
//            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
//        } else {
//            return nums[count / 2];
//        }
        //优化
        return (nums[(count + 1) / 2 - 1] + nums[(count + 2) / 2 - 1] ) / 2.0;

    }

    //2.第二种解法
    //其实不需要将两个数组合并，只需要找出对应的中位数即可
    public static double findMedianSortedArraysSecond(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0, bStart =0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
