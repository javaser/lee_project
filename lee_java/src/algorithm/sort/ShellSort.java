package algorithm.sort;

import algorithm.util.ArrayUtil;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static void sort(int[] arr) {
        int length = arr.length;
        /*
        分组进行直接插入排序
        gap 为间隙
         */
        for (int gap = length / 2; gap > 0; gap /= 2) {
            /*
            从第 i 组开始直接插入排序
             */
            for (int i = 0; i < gap; i++) {
                /*
                i + length 即要插入的数 flag 的位置
                 */
                for (int j = i + gap; j < arr.length; j += gap) {
                    int flag = arr[j];
                    int k; // 随后要帮助定位的数
                    // 大于 flag 的数整体往后移
                    for (k = j - gap; k >= 0 && arr[k] > flag; k -= gap)
                        arr[k + gap] = arr[k];
                    arr[k + gap] = flag; // 插入
                }
            }
        }
    }
}
