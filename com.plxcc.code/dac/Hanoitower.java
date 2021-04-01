package dac;

/**
 * 汉诺塔分治
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(3,'A','B','C');
    }

    /**
     *
     * @param nums 盘数 ，（a,b,c)盘符
     * @param a
     * @param b
     * @param c
     */
    public static void hanoitower(int nums,char a, char b, char c){
        if(nums == 1){
            System.out.println("第一个盘从"+a+"->"+c);
        }else {
            //如果nums>1,将最上面的盘的移动到b盘，移动过程会用到c
            hanoitower(nums-1,a,c,b);
            //将最下面的盘移动到c盘
            System.out.println("第"+nums+"盘由"+a+"->"+c);
            //将b的所有盘移动到c盘
            hanoitower(nums-1,b,a,c);
        }
    }
}
