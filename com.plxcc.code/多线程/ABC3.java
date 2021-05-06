package 多线程;


public class ABC3 {
    public static void main(String[] args) {
        MyPrint myPrint = new MyPrint();
        new Thread(()->{
            for (int i = 0; i < 100;) {
                if(myPrint.getState()%3==1){
                    System.out.print(Thread.currentThread().getName());
                    myPrint.increment();
                    i++;
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 100;) {
                if(myPrint.getState()%3==2){
                    System.out.print(Thread.currentThread().getName());
                    myPrint.increment();
                    i++;
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 100;) {
                if(myPrint.getState()%3==0){
                    System.out.println(Thread.currentThread().getName());
                    myPrint.increment();
                    i++;
                }
            }
        },"C").start();
    }
}
class MyPrint{
    private int state = 1;

    public synchronized void increment(){
        state++;
    }

    public int getState(){
        return this.state;
    }
}
