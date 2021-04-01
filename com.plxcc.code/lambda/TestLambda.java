package lambda;

/**
 * lambda的推导
 */
public class TestLambda {

    //3.静态内部类
    static class Like3 implements Like{
        @Override
        public void run(){
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {
        //4.局部内部类
        class Like4 implements Like{
            @Override
            public void run(){
                System.out.println("局部内部类");
            }
        }

        //5.匿名类
        Like like5 = new Like(){
            @Override
            public void run(){
                System.out.println("匿名类");
            }
        };
        /**
         *6. 用lambda简化
         */
        Like like6 = ()->{
            System.out.println("lambda");
        };
        like6.run();
        /**
         * 7.lambda简化
         */
        ILike iLike = a->{return "hello, I am Lambda";};
        System.out.println(iLike.run(2));
    }
}

//1.定义一个函数式接口
interface Like {
    void run();
}

//7。lambda极致简化
interface ILike{
    String run(int a);
}


//2.定义一个实现类
class Like2 implements Like{
    @Override
    public void run(){
        System.out.println("实习类");
    }
}