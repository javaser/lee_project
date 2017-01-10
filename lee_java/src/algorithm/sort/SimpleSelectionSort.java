package algorithm.sort;

import algorithm.util.ArrayUtil;

public class SimpleSelectionSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i]; // 设 arr[i] 为最小值
            int location = i; // 定位最小值位置
            for (int j = i + 1; j < arr.length; j++) {
                // 得到最小值与其位置
                if (min > arr[j]) {
                    min = arr[j];
                    location = j;
                }
            }
            // 交换
            arr[location] = arr[i];
            arr[i] = min;
        }
    }
}
