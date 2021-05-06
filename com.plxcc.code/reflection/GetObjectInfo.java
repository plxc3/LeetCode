package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class GetObjectInfo {
    public static void main(String[] args) {
        try {
            /**
             * 获取类对象
             */
            //1.通过对象获取
            User user = new User();
            Class<? extends User> class1 = user.getClass();
            System.out.println("class1 HasCode:"+class1.hashCode());
            //2.类名.class ( Class<? extends Student> 或者  Class<?> )
            Class<User> class2 = User.class;
            System.out.println("class2 HashCode:"+class2.hashCode());
            //3.class.forName(),推荐，偶性低，灵活
            Class class3 = Class.forName("reflection.User");
            System.out.println("class3 HashCode:"+class3.hashCode());

            //只能找到public属性
            Field fields [] = class1.getFields();
            //找到全部属性
            fields = class1.getDeclaredFields();
            for(Field field:fields){
                System.out.println(field);
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
