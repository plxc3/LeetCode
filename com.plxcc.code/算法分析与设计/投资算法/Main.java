package 算法分析与设计.投资算法;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  =  new Scanner(System.in);
        int projectNums = scanner.nextInt();
        int money = scanner.nextInt();
        scanner.nextLine();
        int m[][] =new int[money+1][projectNums],planningProfit[][]=new int[money+1][projectNums];
        for (int i = 0; i < money+1; i++) {
            String[] s = scanner.nextLine().split(" ");
            for(int j = 0;j<s.length;j++){
                m[i][j] = Integer.parseInt(s[j]);
            }
        }

        maxProfit(m,projectNums,money,planningProfit);
    }
    public static void maxProfit(int m [][],int projects,int money,int planningProfit[][] ){
        for(int i =0;i<money+1;i++){
            planningProfit[i][0] = m[i][0];
        }
        for(int i = 1;i<projects;++i){
            for(int j =0;j<money+1;++j){
                int maxProfit = m[0][i]+planningProfit[j][i-1];
                for(int k =1;k<j+1;++k){
                    int profit = m[k][i]+planningProfit[j-k][i-1];
                    if(profit>maxProfit){
                        maxProfit =profit;
                    }
                }
                planningProfit[j][i] =maxProfit;
            }
        }
        System.out.println(planningProfit[money][projects-1]);
    }
}