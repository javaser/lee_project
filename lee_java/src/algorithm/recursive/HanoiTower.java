package algorithm.recursive;


import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("请输入汉诺塔的层数：");
        int layer = cin.nextInt();
        move(layer, 'X', 'Y', 'Z');

        cin.close();
    }

    private static void move(int layer, char x, char y, char z) {
        if (layer == 1) {   // 只有一层直接移动
            System.out.println(x + " --> " + z);
        } else {
            move(layer - 1, x, z, y); // 将 x 里的盘子借助 z 柱子移动到 y 柱子
            System.out.println(x + " --> " + z); // 将最后一个盘子直接移动到 z 柱子去
            move(layer - 1, y, x, z); // 将 y 里的盘子借助 x 柱子移动到 z 柱子
        }
    }
}
