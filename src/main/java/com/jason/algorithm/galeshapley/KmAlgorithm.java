package com.jason.algorithm.galeshapley;

/**
 * Kuhn-Munkres 求带权匹配的最大权或最小权（最优匹配）
 * 通过权值, 转化为求是否存在完美匹配
 * Created by jason-geng on 12/17/17.
 */
public class KmAlgorithm {
    static final int UNIT_COUNT = 5;
    /**
     * Xi与Yj对应的权重值
     */
    static int[][] edge = new int[UNIT_COUNT][UNIT_COUNT];

    /**
     * 二分图的相等子图, 即符合当前权重的定点与边的关系（a[i] + b[j] = edge[i][j]）
     */
    static boolean[][] subMap = new boolean[UNIT_COUNT][UNIT_COUNT];

    /**
     * Xi 是否在当前搜索的增广路径上
     */
    static boolean[] xOnPath = new boolean[UNIT_COUNT];

    /**
     * Yj 是否在当前搜索的增广路径上
     */
    static boolean[] yOnPath = new boolean[UNIT_COUNT];

    /**
     * 已找到的增广路径（i->y, path[i]->x）
     */
    static int[] path = new int[UNIT_COUNT];

    /**
     * 最大匹配次数
     */
    static int maxMatch = 0;

    /**
     * 用a[]和b[]的和表示当前的最大权重值
     */
    static int[] a = new int[UNIT_COUNT];
    static int[] b = new int[UNIT_COUNT];

    static {
        edge[0][0] = 3;
        edge[0][1] = 5;
        edge[0][2] = 5;
        edge[0][3] = 4;
        edge[0][4] = 1;

        edge[1][0] = 2;
        edge[1][1] = 2;
        edge[1][2] = 0;
        edge[1][3] = 2;
        edge[1][4] = 2;

        edge[2][0] = 2;
        edge[2][1] = 4;
        edge[2][2] = 4;
        edge[2][3] = 1;
        edge[2][4] = 0;

        edge[3][0] = 0;
        edge[3][1] = 1;
        edge[3][2] = 1;
        edge[3][3] = 0;
        edge[3][4] = 0;

        edge[4][0] = 1;
        edge[4][1] = 2;
        edge[4][2] = 1;
        edge[4][3] = 3;
        edge[4][4] = 3;
    }

    public static void main(String[] args) {
        //1. init（get Max weight）
        for (int i = 0; i < UNIT_COUNT; i++) {
            for (int j = 0; j < UNIT_COUNT; j++) {
                a[i] = Math.max(a[i], edge[i][j]);
            }
        }

        while (true) {
            resetPath();

            //2. get sub map (a[i] + b[j] = weight[i][j]);
            matchEdge2SubMap();

            //3. find augment path
            for (int i = 0; i < UNIT_COUNT; i++) {
                clearOnPathSign();

                if (!findAugmentPath(i)){
                    break;
                }
                maxMatch++;
            }

            //4. match return
            if (maxMatch == UNIT_COUNT) {
                System.out.println("match");
                int[] x2y = new int[UNIT_COUNT];

                for (int i = 0; i < UNIT_COUNT; i++) {
                    x2y[path[i]] = i;
                }

                for (int i = 0; i < UNIT_COUNT; i++) {
                    System.out.println(String.format("%s -> %s", i+1, x2y[i]+1));

                }
                return;
            }

            //5. justify dx
            int dx = Integer.MAX_VALUE;
            for (int i = 0; i < UNIT_COUNT; i++) {
                if (xOnPath[i]){
                    for (int j = 0; j < UNIT_COUNT; j++) {
                        if (!yOnPath[j]){
                            int temp1 = a[i] + b[j];
                            int temp2 = edge[i][j];
                            dx = Math.min(dx, a[i] + b[j] - edge[i][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < UNIT_COUNT; i++) {
                if (xOnPath[i]) {
                    a[i] -= dx;
                }

                if (yOnPath[i]) {
                    b[i] += dx;
                }
            }

        }
    }

    public static void matchEdge2SubMap() {
        for (int i = 0; i < UNIT_COUNT; i++) {
            for (int j = 0; j < UNIT_COUNT; j++) {
                subMap[i][j] = a[i] + b[j] == edge[i][j];
            }
        }
    }

    public static void clearOnPathSign(){
        xOnPath = new boolean[UNIT_COUNT];
        yOnPath = new boolean[UNIT_COUNT];
    }

    public static boolean findAugmentPath(int xi){
        xOnPath[xi] = true;

        for (int yi = 0; yi < UNIT_COUNT; yi++) {
            if (subMap[xi][yi] && !yOnPath[yi]) {
                yOnPath[yi] = true;
                if (path[yi] == -1 || findAugmentPath(path[yi])) {
                    path[yi] = xi;
                    return true;
                }
            }
        }
        return false;
    }

    public static void resetPath(){
        for (int i = 0; i < UNIT_COUNT; i++) {
            path[i] = -1;
        }
        maxMatch = 0;
    }
}
