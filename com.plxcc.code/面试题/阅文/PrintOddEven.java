package 面试题.阅文;

public class PrintOddEven {
    public static void main(String[] args) {
        MyData myData = new MyData();
        while (myData.getA()<=10){
            new Thread(()->myData.print(),"A").start();
            new Thread(()->myData.print(),"B").start();
        }
    }
}

class MyData{
    private int a = 1;

    public synchronized void print(){
        if(a>10){
            return;
        }
        if(a%2 == 0&&Thread.currentThread().getName().equals("A")){
            System.out.println(Thread.currentThread().getName()+" "+a);
            a++;
        }
        if(a%2 == 1&&Thread.currentThread().getName().equals("B")){
            System.out.println(Thread.currentThread().getName()+" "+a);
            a++;
        }
    }

    public int getA() {
        return a;
    }
}