package 多线程;

public class ScaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            ticket.scale();
        },"A").start();
        new Thread(()->{
            ticket.scale();
        },"B").start();
        new Thread(()->{
            ticket.scale();
        },"C").start();
    }
}
class Ticket{
    private int ticket = 50 ;
    public synchronized void scale(){
        for (int i = 0; i < ticket; i++) {
            System.out.println(Thread.currentThread().getName()+"卖出去第"+(ticket--)+"张票"+"剩余"+ticket+"张票");
        }
    }
}
