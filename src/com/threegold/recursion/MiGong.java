package com.threegold.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 1. 先创建一个地图, 终点位置是 map[6][5]
        int[][] map = new int[8][7];

        // 使用 1 表示墙, 先把上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 把左右全部置为 1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
        setWay2(map, 1, 1);
        // 输出新的地图, 小球走过并标识过的地图
        System.out.println("输出新的地图, 小球走过并标识过的地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 约定：当前 map[i][j] = 0 表示没有走过，为 1 表示为墙，为 2 表示通路可以走；3 表示该点已经走过，但是走不通
     * 走迷宫策略：下 -> 右 -> 上 -> 左
     * 
     * @param map 地图
     * @param i   从那个位置开始找
     * @param j
     * @return 如果找到通路就返回 true，否则就返回 false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 当前这个点没有走过
                map[i][j] = 2; // 假定该点可以走通
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else { // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    // 修改找路策略，改成 上 -> 右 -> 下 -> 左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 当前这个点没有走过
                map[i][j] = 2; // 假定该点可以走通
                if (setWay2(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) { // 向左走
                    return true;
                } else { // 说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
