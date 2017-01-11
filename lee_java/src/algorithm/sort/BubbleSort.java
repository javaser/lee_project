package algorithm.sort;

import algorithm.util.ArrayUtil;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static void sort(int[] arr) {
        // 最后一个不需要遍历，当作每次最大数的存储位
        for (int i = 0; i < arr.length - 1; i++) {
            // 减 1 理由同上，减 i 是不需要再次遍历已经排好序的
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 每次都比较大小，像泡泡那样最后越来越大
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
