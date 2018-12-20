import java.lang.reflect.InvocationTargetException;

//测试类
public class ReflectTest {
    public static void main(String[] agrs) throws InvocationTargetException {
        //注意一定要返回接口，不能返回实现类，否则会报错
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class,new Apple());
        fruit.show();
    }
}
