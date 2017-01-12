package algorithm.sort;

import algorithm.util.ArrayUtil;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static void sort(int[] arr) {
        _sort(arr, 0, arr.length - 1);
    }

    private static void _sort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        _sort(arr, left, center);
        // 对右边数组进行递归
        _sort(arr, center + 1, right);
        // 合并
        merge(arr, left, center, right);
    }

    /*
    将两个数组进行归并
     */
    private static void merge(int[] arr, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[arr.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (arr[left] <= arr[mid])
                tmpArr[third++] = arr[left++];
            else
                tmpArr[third++] = arr[mid++];
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right)
            tmpArr[third++] = arr[mid++];
        while (left <= center)
            tmpArr[third++] = arr[left++];

        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right)
            arr[tmp] = tmpArr[tmp++];
    }
}
