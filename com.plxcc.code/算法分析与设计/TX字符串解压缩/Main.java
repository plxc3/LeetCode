package 算法分析与设计.TX字符串解压缩;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(uZip(str));
    }
    public static String uZip(String str){
        while (str.contains("]")){
            int right = str.indexOf("]");
            int left  = str.lastIndexOf("[",right);
            String replaceStr = str.substring(left+1,right);
            String []s =replaceStr.split("\\|");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < Integer.parseInt(s[0]); i++) {
                stringBuffer.append(s[1]);
            }
            String newStr ="["+replaceStr+"]";
            str=str.replace(newStr,stringBuffer);
        }
        return str;
    }
}
