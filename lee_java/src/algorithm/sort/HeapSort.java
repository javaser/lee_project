package algorithm.sort;

import algorithm.util.ArrayUtil;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = ArrayUtil.getIntArr();
        ArrayUtil.printArr(arr, false);
        arr = sort(arr);
        ArrayUtil.printArr(arr, true);
    }

    /*
    排序前要知道树以数组形式表示的规律：
    假如当前节点为 k，则：
    父节点：(k-1)/2
    左孩子：2k+1
    右孩子：2k+2
     */
    private static int[] sort(int[] a) {
        int count = 0; // 弹出的第 count 个堆顶元素
        int[] temp = new int[a.length]; // 用来接收堆顶元素

        // 建立初始堆
        for (int i = (a.length - 1) / 2; i >= 0; i--)
            heapOne(a, a.length, i);

        // 边输出堆顶，边调整
        int n = a.length; // 剩余元素数
        while (n > 0) {

            temp[count++] = a[0]; // 接收弹出堆顶元素
            a[0] = a[n - 1]; // 最后一个元素移动到堆顶
            n--;
            heapOne(a, n, 0);
        }

//        System.arraycopy(temp, 0, basic, 0, temp.length);
        return temp;
    }

    /*
    节点 k 进行筛选
    basic: 堆数据，n: 堆中有效数据个数，k: 待筛选节点
     */
    private static void heapOne(int[] a, int n, int k) {
        int k1 = 2 * k + 1;
        int k2 = 2 * k + 2;
        if (k1 >= n && k2 >= n) return; // 已经是叶子了

        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        if (k1 < n) a1 = a[k1]; // 左孩子值
        if (k2 < n) a2 = a[k2]; // 右孩子值

        if (a[k] <= a1 && a[k] <= a2) return; // 已经符合堆的要求了

        // 找到左右孩子中最小的，和它交换
        if (a1 < a2) { // 左孩子替换成父节点
            int t = a[k];
            a[k] = a[k1];
            a[k1] = t;
            heapOne(a, n, k1); // 继续筛选子树
        } else {
            int t = a[k];
            a[k] = a[k2];
            a[k2] = t;
            heapOne(a, n, k2);
        }
    }
}
