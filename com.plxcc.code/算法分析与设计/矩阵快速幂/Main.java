package 算法分析与设计.矩阵快速幂;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main{

    private static final int[][] UNIT = {{1, 1}, {1, 0}};

    private static final int[][] ZERO = {{1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        while (true) {
            // 第n个斐波那契数,从0开始
            int n = scanner.nextInt();
            if(n == -1){
                break;
            }
            list.add(n);
        }
        for(int i = 0;i<list.size();i++){
            if(list.get(i)==0){
                System.out.println(0);
            }else {
                int[][] m = fb(list.get(i));
                System.out.println(m[0][1]);
            }
        }
    }
    public static int[][] fb(int n) {
        if(n <1){
            return UNIT;
        }
        int res[][] = ZERO;
        int a[][]=UNIT;
        while(n!=0){
            if((n&1)==1)
                res=matrixMultiply(res,a);
            a = matrixMultiply(a,a);
            n >>= 1;
        }
        return res;
    }

    public static int[][] matrixMultiply(int[][] m, int[][] n) {
        int rows = m.length;
        int cols = n[0].length;
        int[][] r = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                r[i][j] = 0;
                for (int k = 0; k < m[i].length; k++) {
                    r[i][j] += m[i][k] * n[k][j];
                }
                r[i][j]%=10000;
            }
        }
        return r;
    }

}