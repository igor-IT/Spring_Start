package spring_start;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    private Random random = new Random();
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Set<Field> allFields = ReflectionUtils.getAllFields(type, field -> field.isAnnotationPresent(InjectRandomInt.class));
        for (Field fields: allFields) {
            InjectRandomInt annotation = fields.getAnnotation(InjectRandomInt.class);
            int min = annotation.min();
            int max = annotation.max();
            int value = random.ints(min,max).findAny().getAsInt();
            fields.setAccessible(true);
            fields.set(t,value);
        }
    }
}
