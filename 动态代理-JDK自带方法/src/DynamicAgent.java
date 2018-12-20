import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class DynamicAgent {
    //实现InvocationHandler接口，并且可以初始化被代理类的对象
    static class Myhandler implements InvocationHandler{
        private Object proxy;
        public Myhandler(Object proxy){
            this.proxy=proxy;
        }
        //自定义invoke方法
        @Override
        public Object invoke(Object proxy, Method method,Object[] agrs) throws Throwable{
            System.out.println(">>>>before invoking.");
            //真正调用方法的地方
            Object ret = method.invoke(this.proxy,agrs);
            System.out.println(">>>>after invoking.");
            return ret; //返回值
        }
    }
    //返回一个被修改的对象
    public static Object agent(Class interfaceClazz,Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                new Class[]{interfaceClazz},new Myhandler(proxy));
    }
}
