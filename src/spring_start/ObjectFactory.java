package spring_start;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
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
    }
    @SneakyThrows
    public <T> T createObject(Class<T> type){
         type = resolveImpl(type);
         T t = create(type);
         configure(t);
         return t;
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
            type = config.getImplClass(type);
        }
        return type;
    }
}
