package leetCodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56.合并区间
 * 链接：https://leetcode.cn/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author xmy
 * @date 2023/5/4 8:36 下午
 */
public class IntervalsMerge56 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8,10},{15,18}};

    }

    public int[][] merge(int[][] intervals) {
        //如果只存在一个元素，那么不需要进行任何处理
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> resList = new ArrayList<>();
        //按照二位数组中的一维数组的第一个元素从小到大排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] tmp = intervals[0];
        resList.add(tmp);
        for (int i = 1; i < intervals.length; i++) {
            if (tmp[1] < intervals[i][0]) {
                //第一个的末端元素 < 第二个元素的开头，不能合并区间，直接添加
                resList.add(intervals[i]);
                tmp = intervals[i];

            } else if (tmp[1] >= intervals[i][0] && tmp[1] <= intervals[i][1]) {
                //第一个的末端元素 处于第二个元素的中间位置，那么合并区间，取第一个元素的开头和第二个元素的结尾
                resList.remove(tmp);
                tmp = new int[]{tmp[0], intervals[i][1]};
                resList.add(tmp);
            }
        }
        //为什么要使用tmp，自己写的时候使用的是a[i] 和a[i+1]比较，这是因为对于第三种情况，你合并之后，需要拿到合并的区间去和下一个区间比较，所以要是使用tmp存储想用的区间
        return resList.toArray(new int[resList.size()][2]);
    }



}
