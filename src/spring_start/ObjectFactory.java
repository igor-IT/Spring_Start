package spring_start;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private  Reflections scanner = new Reflections("spring_start");
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> configuratorsProxy = new ArrayList<>();
    public static ObjectFactory getInstance(){
        return ourInstance;
    }
    @SneakyThrows
    private ObjectFactory(){
        Reflections scanner = new Reflections("spring_start");
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes){
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
        Set<Class<? extends ProxyConfigurator>> set = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : set){
            configuratorsProxy.add(aClass.getDeclaredConstructor().newInstance());
        }
    }
    @SneakyThrows
    public <T> T createObject(Class<T> type){
         type = resolveImpl(type);
         T t = create(type);
         configure(t);
         configureInitMet(t);
         for (ProxyConfigurator proxyConfigurator: configuratorsProxy){
             t = (T) proxyConfigurator.wrapWitchProxy(t,type);
         }
         return t;
    }
    @SneakyThrows
    private void configureInitMet(Object t) {
        Class<?> aClass = t.getClass();
        Set<Method> allMethods = ReflectionUtils.getAllMethods(aClass, method -> method.isAnnotationPresent(Init.class));
        for (Method method: allMethods){
            method.invoke(t);
        }
    }
    private <T> void configure(T t){
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t));
    }
    @SneakyThrows
    private <T> T create(Class<T> type){
        return type.getDeclaredConstructor().newInstance();
    }
    private <T> Class<T> resolveImpl(Class<T> type){
        if (type.isInterface()){
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null){
                Set<Class<? extends T>> subTypesOf = scanner.getSubTypesOf(type);
                if (subTypesOf.size() != 1){
                    throw new RuntimeException("Update config");
                }
                type = (Class<T>) subTypesOf.iterator().next();
            }else {
                type = implClass;
            }
        }
        return type;
    }
}
