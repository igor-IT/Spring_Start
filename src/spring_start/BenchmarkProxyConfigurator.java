package spring_start;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    private BenchmarkToggle benchmarkToggle = new BenchmarkToggle();
    @Override
    public <T> Object wrapWitchProxy(Object object, Class<T> type) {
        if (type.isAnnotationPresent(Benchmark.class) || Arrays.stream(type.getMethods()).allMatch(method -> method.isAnnotationPresent(Benchmark.class))){
            if (type.getInterfaces().length == 0){
                return Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
                        if (benchmarkToggle.isEnabled() && type.isAnnotationPresent(Benchmark.class) || classMethod.isAnnotationPresent(Benchmark.class)){
                            System.out.println("BENCHMARK START - "+method.getName());
                            long start = System.nanoTime();
                            Object retValue = method.invoke(object, objects);
                            long end  = System.nanoTime();
                            System.out.println(end - start);
                            System.out.println("BENCHMARK FINISHED - "+method.getName());
                            return retValue;
                        }
                        return method.invoke(object,objects);
                    }
                });
            }
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
