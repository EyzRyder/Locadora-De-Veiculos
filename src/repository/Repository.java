package repository;

public abstract class Repository {

    public abstract void getOne();
    public abstract void getAll();
    public abstract void add(Object item);
    public abstract void delete(Object id);
}
