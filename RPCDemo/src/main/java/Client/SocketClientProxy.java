package Client;

/**
 * @author y1881
 * @date 2020.3.28 9:39
 */

import Entity.Request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象SocketClientProxy.java 采用动态代理的方式
 */
public class SocketClientProxy {
    private socketClient sock = new socketClient();
    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class<?>[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Request request = new Request();
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setMethodName(method.getName());
                        request.setParamTypes(method.getParameterTypes());
                        request.setParams(args);
                        return sock.invoke(request,"127.0.0.1",12000);
                    }
                });
    }
}
