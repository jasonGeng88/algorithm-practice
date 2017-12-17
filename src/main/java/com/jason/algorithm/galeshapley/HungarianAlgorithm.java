package com.jason.algorithm.galeshapley;

/**
 * 匈牙利算法
 * 解决最大匹配与完美匹配问题
 * 例: 男女配对问题, 得出最大匹配数或是否存在完美匹配（主动一方以最可能的稳定匹配结束,被动一方以最差的匹配结束)
 * Created by jason-geng on 12/16/17.
 */
public class HungarianAlgorithm {

    final static int UNIT_COUNT = 5;
    static int[][] edge = new int[UNIT_COUNT][UNIT_COUNT];
    static int[] path = new int[UNIT_COUNT];
    static boolean[] onPath = new boolean[UNIT_COUNT];
    static int maxMatch;

    static  {
        edge[0][2] = 1;
        edge[1][0] = 1;
        edge[1][1] = 1;
        edge[2][1] = 1;
        edge[2][2] = 1;
        edge[2][3] = 1;
        edge[3][1] = 1;
        edge[3][2] = 1;
        edge[4][2] = 1;
        edge[4][3] = 1;
        edge[4][4] = 1;

        for (int i = 0; i < UNIT_COUNT; i++) {
            path[i] = -1;
        }
    }

    public static void main(String[] args) {
        for (int xi = 0; xi < UNIT_COUNT; xi++) {

            if (findAugmentPath(xi)) {
                maxMatch++;
            }
            onPath = new boolean[5];
        }

        printMatch();
    }

    public static boolean findAugmentPath(int xi) {
        for (int yi = 0; yi < 5; yi++) {

            if (edge[xi][yi] == 1 && !onPath[yi]) {
                onPath[yi] = true;

                if (path[yi] == -1 || findAugmentPath(path[yi])){
                    path[yi] = xi;
                    return true;
                }
            }
        }
        return false;
    }

    public static void printMatch() {
        System.out.println(String.format("完美匹配: %s", maxMatch == UNIT_COUNT ? "是" : "不是"));
        int[] x2y = new int[UNIT_COUNT];

        for (int i = 0; i < UNIT_COUNT; i++) {
            x2y[path[i]] = i;
        }

        System.out.println("x -> y");
        for (int i = 0; i < UNIT_COUNT; i++) {
            System.out.println(String.format("%s -> %s", i, x2y[i]));
        }
    }

}
