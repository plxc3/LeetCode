package reflection;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *JAVA中利用反射机制进行对象和Map相互转换的方法
 * @author petergreen
 */
public class JavaBeanMapUtil {

    public static void main(String[] args) {
        User user = new User("Bob",21,"main");
        JavaBeanMapUtil javaBeanMapUtil = new JavaBeanMapUtil();
        Map<String, Object> map = javaBeanMapUtil.JavaBeanToMap(user);
        System.out.println(map.toString());
        System.out.println(javaBeanMapUtil.mapToJavaBean(User.class,map).toString());
    }


    public Map<String,Object> JavaBeanToMap(Object javaBean){
        Map<String,Object> map = new HashMap<>();
        try {
           Method[] methods = javaBean.getClass().getMethods();
           for(Method method:methods){
             if(method.getName().startsWith("get")){
                 String field = method.getName();
                 field = field.substring(field.indexOf("get")+3);
                 field = field.toLowerCase().charAt(0)+field.substring(1);
                 Object value = method.invoke(javaBean,null);
                 map.put(field,value);
             }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return map;
    }

    public Object mapToJavaBean(Class<?> clazz,Map<String,Object> map){
        Object javaBean = null;
        try{
            javaBean = clazz.newInstance();
            Method[] methods = javaBean.getClass().getMethods();
            for(Method method:methods){
                if(method.getName().startsWith("set")){
                    String field = method.getName();
                    field = field.substring(field.indexOf("set")+3);
                    field = field.toLowerCase().charAt(0)+field.substring(1);
                    method.invoke(javaBean,map.get(field));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return javaBean;
    }
}
