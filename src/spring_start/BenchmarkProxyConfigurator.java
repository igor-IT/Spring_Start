package spring_start;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> Object wrapWitchProxy(Object object, Class<T> type) {
        if (type.isAnnotationPresent(Benchmark.class) || Arrays.stream(type.getMethods()).allMatch(method -> method.isAnnotationPresent(Benchmark.class))){
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    System.out.println("BENCHMARK START - "+method.getName());
                    long start = System.nanoTime();
                    Object retValue = method.invoke(object, objects);
                    long end  = System.nanoTime();
                    System.out.println(end - start);
                    System.out.println("BENCHMARK FINISHED - "+method.getName());
                    return retValue;
                }
            });
        }
        return object;
    }
}
