package spring_start;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Set<Field> allFields = ReflectionUtils.getAllFields(t.getClass(), field -> field.isAnnotationPresent(InjectByType.class));
        for (Field field: allFields){
            field.setAccessible(true);
            Object object = ObjectFactory.getInstance().createObject(field.getType());
            field.set(t,object);
        }
    }
}
