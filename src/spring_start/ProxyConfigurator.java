package spring_start;

public interface ProxyConfigurator {
    <T> Object wrapWitchProxy(Object object, Class<T> type);
}
