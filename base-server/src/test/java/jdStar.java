import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class jdStar {

    // accept

    /**
     * <p>
     * 小A 和 小B进行猜数字游戏 A在随机选择一个整数K并给出Q个提示， 小B猜 。每次给出的提示中包含两个整数M，D  表示M与K的差的绝对值不超过D。 现在小B想根据小A给出的Q条提示找出满足提示的最大的K
     * <p>
     * 输入描述：
     * 第一行包含整数Q 代表Q个提示
     * 随后Q行 每行给出两个整数M，D
     * 输出满足提示的最大的K 没有输出 -1
     * <p>
     * 示例 ：
     * 3
     * 3 3
     * 2 5
     * 5 3
     * 输出 6
     * </p>
     */
    void T1() {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        int minK = Integer.MIN_VALUE;
        int maxK = Integer.MAX_VALUE;

        for (int i = 0; i < Q; i++) {
            // 拿到M
            int M = scanner.nextInt();
            // 拿到提示D
            int D = scanner.nextInt();
            minK = Math.max(minK, M - D);

            maxK = Math.min(maxK, M + D);
        }

        // 检查
        if (minK > maxK) {
            System.out.println(-1);
        } else {
            System.out.println(maxK);
        }
        scanner.close();
    }

    // accept
    /**
     * <p>
     * 头顶标数字 ，三层标3 二层标2 一层标1 ，全部加起来即可 。 现在给定一个矩阵 矩阵中的每个数字表示这个位置上叠放小正方体的数量 小正方体边长为1 请问：题目所描述几何体的三视图 正面、左面、上方看的投影各自面积为多少？
     * 输入描述：
     * 一行两个整数n，m表示矩阵行和列
     * 之后n行每行m个整数 aij 表示该位置叠放了aij个小正方体
     * 输出三个整数 依次代表从正面左面和上方看过去的投影面积。
     * 示例：
     * 2 3
     * 3 3 2
     * 3 2 1
     * 输出：
     * 8 6 6
     * 解释：从正面看 面积为8
     * 左边是 3乘2 面积6
     * 上面看是 2乘3 面积为6
     * </p>
     */
    void T2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int leftArea = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[i][j]);
            }
            leftArea += max;
        }

        int frontArea = 0;
        for (int j = 0; j < m; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            frontArea += max;
        }

        // 非零数量
        int topArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0) {
                    topArea++;
                }
            }
        }
        System.out.println(frontArea + " " + leftArea + " " + topArea);

        scanner.close();
    }

    // ac不动了
    /**
     * <p>
     * 一个国家有n个城市，国王希望所有城市连通起来 ，现在国王下令所有施工队同时施工，已知施工队的施工速度为1距离单位/年，每个城市的领导者都会向相邻的城市派出施工队（所有城市相邻），并且每个施工队都按最短路线修路，两个施工队碰头，那么两个城市相连。
     * 现在给出n个城市的坐标，国王想知道多少年才能全部连通。
     * 输入描述：
     * 第一行一个整数n 表示城市数量
     * 接下来n行每行两个整数 xi yi 空格分隔表示城市坐标。
     * 输出一个整数表示城市相连的年数 （向上取整结果 如2.5年输出3）
     * 示例1:
     * 3
     * 0 0
     * 0 5
     * 6 0
     * 输出： 3
     * 说明：当6 0 和 0 0连在一起时所有城市连在一起 需要3 年
     * </p>
     */
    void T3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] cities = new double[n][2]; // x, y
        for (int i = 0; i < n; i++) {
            cities[i][0] = scanner.nextDouble();
            cities[i][1] = scanner.nextDouble();
        }
        // 最大 maxDistance 初始化
        double maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt((cities[j][0] - cities[i][0]) * (cities[j][0] - cities[i][0])
                        + (cities[j][1] - cities[i][1]) * (cities[j][1] - cities[i][1]));
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }
        // qu zheng
//        int ceil = (int) Math.ceil(maxDistance);
        System.out.println((int) Math.ceil(maxDistance));
        scanner.close();
    }
}
