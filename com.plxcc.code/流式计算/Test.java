package 流式计算;

import sun.rmi.server.UnicastServerRef;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("张三",10,'Z');
        User user2 = new User("李四",18,'L');
        User user3 = new User("小红",15,'X');
        User user4 = new User("老王",9,'L');
        User user5 = new User("大佬",16,'D');
        List<User> users = Arrays.asList(user1,user2,user3,user4,user5);
        users.stream().filter((user)->{
            return user.getInitials() == 'L';
        }).limit(1L).forEach((user)-> System.out.println(user.getName()));
    }
}
class User{
    private String name;
    private int  age;
    private char initials;

    public User(String name,int age,char initials){
        this.name = name;
        this.age = age;
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getInitials() {
        return initials;
    }
}
