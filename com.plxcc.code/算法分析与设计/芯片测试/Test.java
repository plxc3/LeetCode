package 算法分析与设计.芯片测试;

import java.util.*;

class Num{
    private int value = 0;
    private int index =0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Num> nums = new LinkedList<>();
        int m [] = new int[n];
        int flag[] = new int[10000];
        String s = in.nextLine();
        String str[] = s.split(" ");
        Set<Integer> set =new HashSet<>();
        for(int i = 0;i<str.length;i++){
            if(set.contains(Integer.parseInt(str[i]))){
                flag[Integer.parseInt((str[i]))]++;
            }else {
                set.add(Integer.parseInt(str[i]));
                flag[Integer.parseInt(str[i])]=0;
            }
            Num num = new Num();
            num.setValue(Integer.parseInt(str[i]));
            m[i] = Integer.parseInt(str[i]);
            num.setIndex(i+1);
            nums.add(num);
        }
        System.out.println(getRight(nums,nums.size()).getIndex());
    }

    public static Num getRight(List<Num> nums,int n){
      if(n == 3){
          if(nums.get(0).getValue() == nums.get(1).getValue()){
              return nums.get(0);
          }else {
              return nums.get(2);
          }
      }else if(n == 2 || n==1){
          return nums.get(0);
      } else if(n%2 == 0){
          List<Num> newList = new LinkedList<>();
          for(int i =0;i<n;i+=2){
              if(nums.get(i).getValue() == nums.get(i+1).getValue()){
                  newList.add(nums.get(i));
              }
          }
         return getRight(newList,newList.size());
      }else{
         int good =0;
         for(int i = 0;i<n;i++){
             if(nums.get(i).getValue() == nums.get(n-1).getValue()){
                 good++;
             }
         }
         if(good>n/2){
             return nums.get(n-1);
         }else {
             return getRight(nums,nums.size()-1);
         }
      }
    }

}
