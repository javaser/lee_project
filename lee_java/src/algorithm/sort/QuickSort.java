package algorithm.sort;

import algorithm.util.ArrayUtil;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    private static int getMiddle(int[] a, int left, int right) {
        int tmp = a[left];    //数组的第一个作为中轴
        while (left < right) {
            while (left < right && a[right] >= tmp) {
                right--;
            }
            a[left] = a[right];   //比中轴小的记录移到左边
            while (left < right && a[left] <= tmp) {
                left++;
            }
            a[right] = a[left];   //比中轴大的记录移到右边
        }
        a[left] = tmp;              //中轴记录到尾
        return left;                   //返回中轴的位置
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = getMiddle(a, left, right);  //将 basic 数组进行一分为二
            quickSort(a, left, middle - 1);       //对左边进行递归排序
            quickSort(a, middle + 1, right);       //对右边进行递归排序
        }
    }

    public static void sort(int[] a) {
        if (a.length > 0) {    //查看数组是否为空
            quickSort(a, 0, a.length - 1);
        }
    }
}
