## Spring AOP之『代理模式』

### 静态代理
![](https://images2015.cnblogs.com/blog/756310/201609/756310-20160924153802543-1643119235.jpg)
可以看到还是很简单的，代理类实现了被代理类的接口，同时与被代理类是组合关系。  
### 动态代理
#### JDK自带方法  
**最核心的一个接口和一个方法：**  
首先是`java.lang.reflect`包里的`InvocationHandler`接口：
```$xslt
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable;
}
```
我们对于被代理的类的操作都会由该接口中的`invoke`方法实现，其中的参数的含义分别是：

- proxy：被代理的类的实例  
- method：调用被代理的类的方法  
- args：该方法需要的参数  

使用方法首先是需要实现该接口，
并且我们可以在invoke方法中调用被代理类的方法并获得返回值，
自然也可以在调用该方法的前后去做一些额外的事情，
从而实现动态代理。  
另外一个很重要的静态方法是`java.lang.reflect`包中的`Proxy`类的`newProxyInstance`方法：
```$xslt
public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
    throws IllegalArgumentException
```
其中的参数含义如下：

- loader：被代理的类的类加载器  
- interfaces：被代理类的接口数组  
- invocationHandler：就是刚刚介绍的调用处理器类的对象实例  

该方法会返回一个被修改过的类的实例，从而可以自由的调用该实例的方法。  
对于不同的实现类来说，可以用同一个动态代理类来进行代理，
实现了“一次编写到处代理”的效果。
但是这种方法有个缺点，就是被代理的类一定要是实现了某个接口的，
这很大程度限制了本方法的使用场景。

#### CGLIB库的方法  
CGlib是一个字节码增强库，为AOP等提供了底层支持。

#### AspectCore的方法

---
参考：  
http://www.cnblogs.com/puyangsky/p/6218925.html
https://www.cnblogs.com/liuhaoyang/p/aspectcore-getting-started.html