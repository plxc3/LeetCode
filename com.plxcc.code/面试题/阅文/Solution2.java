package 面试题.阅文;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countBit(n));
    }

    public static int countBit(int n){
        int count = 0;
        while (n>0){
            if((n&1) ==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
}
