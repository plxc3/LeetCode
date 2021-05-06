package 面试题.阅文;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replace("\"","").replace("]","").replace("[","");
        List<String> numbers= Arrays.asList(str.split(","));
        BigInteger bigInteger = new BigInteger("0");
        for (int i = 0; i < numbers.size(); i++) {
         bigInteger=bigInteger.add(new BigInteger(numbers.get(i)));
        }
        System.out.println(bigInteger.toString());
    }


}
