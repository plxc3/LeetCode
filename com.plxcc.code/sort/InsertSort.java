package sort;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int m[]=new int[]{101,34,56,78,90,32,56,77};
        insertSort(m);
    }
    public static void insertSort(int []arry){
        for(int i=1;i<arry.length;i++){
            int insertVal = arry[i];
            int insertIndex = i-1;
            while(insertIndex>=0&&insertVal<arry[insertIndex]){
                arry[insertIndex+1] = arry[insertIndex];
                insertIndex--;
            }
            arry[insertIndex+1] = insertVal;
            System.out.println("第"+i+"轮"+ Arrays.toString(arry));
        }
    }
}
