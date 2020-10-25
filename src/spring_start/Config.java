package spring_start;

public interface  Config {
    <T> Class<T> getImplClass(Class<T> type);
}
