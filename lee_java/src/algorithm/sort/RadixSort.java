package algorithm.sort;

import algorithm.util.ArrayUtil;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr, 2);
        ArrayUtil.printArr(arr, true);
    }

    static void sort(int[] arr, int d) { // d 表示数字最大有多少位，65 则为 2
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][arr.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < arr.length; i++) {
                int lsd = ((arr[i] / n) % 10);
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
