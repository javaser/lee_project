package algorithm.sort;

import algorithm.util.ArrayUtil;

public class DirectInsertionSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getFixIntArr(6);
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static void sort(int[] arr) {

        // 第一位当作长度为 1 且为升序的数组
        for (int i = 1; i < arr.length; i++) {
            int location = i - 1; // location 为升序数组最后一位的位置
            // 得到旗帜 arr[i]
            int flag = arr[i];
            // 从后往前遍历
            for (; location >= 0; location--) {
                // 大于旗帜的数往后移
                if (flag < arr[location])
                    arr[location + 1] = arr[location];
                else // 找到插入位置
                    break;
            }
            /*
            最后，所有大于 flag 的数都往后移了（可能 flag 比 arr[0]还小）
            即最坏的打算，复杂度为 O(n)，n 为升序数组的长度
             */
            arr[location + 1] = flag;
        }
    }
}
