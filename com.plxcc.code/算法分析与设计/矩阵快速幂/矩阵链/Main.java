package 算法分析与设计.矩阵快速幂.矩阵链;

import java.util.Scanner;
public class Main {
    static int N=100;
    static int []p=new int[N];//记录矩阵的行和列，第i个矩阵的行数存储在数组的第i-1个位置，列数存储在数组的第i个位置。
    static int [][]m=new int[N][N];//表示AiAi+1A...Aj矩阵连乘的最优值
    static int [][]s=new int[N][N];//存放各个子问题的最优决策
    static int n;//多少个数组
    static void matrixchain(){
        int i,j,r,k;
        //初始化数组，使m[][],s[][]对角线上的元素为0
        for( i=0;i<N;i++){
            for (j=0;j<N;j++){
                if(i==j){
                    m[i][j]=0;
                    s[i][j]=0;
                }
            }
        }
        for(r=2;r<=n;r++){//r为问题规模，处理不同规模的子问题
            for(i=1;i<=n-r+1;i++){
                j=i+r-1;
                m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];//决策为k=i的乘法次数
                s[i][j]=i;//子问题的最优策略是i
                for(k=i+1;k<j;k++){//对从i+1到j的所有决策，求最优值
                    int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j])
                    {
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
            }
        }
    }
    static void print(int i,int j){
        if(i==j){
            System.out.print("A"+i);
            return;
        }
        System.out.print("(");
        print(i,s[i][j]);
        print(s[i][j]+1,j);
        System.out.print(")");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int i,j;
        for (i=0;i<=n;i++){
            p[i]=sc.nextInt();
        }
        matrixchain();
        System.out.println(m[1][n]);
        print(1,n);
    }
}
