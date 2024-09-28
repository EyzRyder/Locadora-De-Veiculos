package repository;

public interface Repositorio<T> {

    T find(String key);

    void update(T item);

    void add(T item);

    void delete(T item);

}
