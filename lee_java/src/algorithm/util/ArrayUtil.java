package algorithm.util;

import java.util.Random;

public class ArrayUtil {

    private static final Random RANDOM;

    static {
        RANDOM = new Random(System.currentTimeMillis());
    }

    private ArrayUtil() {
    }

    public static void printArr(int[] arr) {
        System.out.print("\n[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.print("]");
    }

    /**
     * 数组最少长度为 6
     * @return int 类型数组
     */
    public static int[] getIntArr() {
        int length = RANDOM.nextInt(16) + 6;
        int[] result = new int[length];
        for (int i = 0; i < length; i++)
            result[i] = RANDOM.nextInt(100);
        return result;
    }

    public static void printArr(int[] arr, boolean sorted) {
        if (sorted)
            System.out.println("已排序：");
        else
            System.out.println("未排序：");

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]).append("]");
        System.out.println(sb.toString());
    }

}
