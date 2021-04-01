import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //用数组来存储芯片，1代表为好的芯片，0代表为坏的芯片，下面的数组总有23个芯片，12个为好的
        int[] arr = {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(getRight(arr,arr.length)));
    }

    //定义一个测试平台，来模拟题干中的测试装置，好的芯片输出对的，坏的芯片随机输出
    public static boolean[] judge(int x, int y) {
        boolean[] result = new boolean[2];
        if (x == 1 && y == 1) {
            result[0] = true;
            result[1] = true;
        } else if (x == 1 ^ y == 1) {
            result[0] = false;
            result[1] = ((int) (Math.random() * 2)) == 1;
        } else {
            result[0] = ((int) (Math.random() * 2)) == 1;
            result[1] = ((int) (Math.random() * 2)) == 1;
        }
        return result;
    }

    //返回一个正确的芯片
    public static int[] getRight(int[] arr,int length) {
        //当芯片个数小于等于2时，均为好的芯片，返回
        if (length<= 2) {
            int[] z = new int[length];
            for (int i = 0; i < length; i++) {
                z[i] = arr[i];
            }
            return z;
        }
        //这里用数组存储选出来的芯片，数组定义为最坏情况下的长度，其它情况数组后边可能有多余的位数
        //所以用length来标明数组中的有效长度
        int[] tmp = new int[length / 2 + 1];
        boolean[] result = null;//这个数组用来接收测试结果

        int point = 0;//记录选出来的芯片个数
        //芯片两两为一组，进行测试
        for (int i = 0; i < length-1; i += 2) {
            result = judge(arr[i], arr[i + 1]);
            if (!result[0] ^ result[1]) {
                //两个芯片都测试为好的情况，则随机选出其中一个芯片
                int x = (int) (Math.random() * 2);
                tmp[point] = arr[i + x];
                point++;
            }
        }
        //考虑总个数为奇数的情况
        if (length % 2 == 1) {
            //这时要根据选出来的个数进行判断，偶数就加进去，奇数就扔掉
            if (point % 2 == 0) {
                tmp[point] = arr[length - 1];
                point++;
            }
        }
        //递归，继续两两进行测试，直到芯片个数少于3个
        return getRight(tmp,point);
    }
}
