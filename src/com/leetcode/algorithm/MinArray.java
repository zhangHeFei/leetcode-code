package com.leetcode.algorithm;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：二分搜索
 */
public class MinArray {

    public int minArray(int[] numbers) {

        if (numbers.length == 0){
            return -1;
        }

        if (numbers.length == 1){
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;
        int mid = Math.floorDiv(left + right, 2);
        while (mid != left && mid != right){
            if (numbers[mid] > numbers[right]){
                left = mid;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else{
                right --;
            }
            mid = Math.floorDiv(left + right, 2);
        }
        return mid == left ? Math.min(numbers[mid], numbers[right]) : Math.min(numbers[mid], numbers[left]);
    }
}
