package dao;

import java.util.List;

public interface InterfaceDao <T>{
    public void save(T t);
    public void update(T t);
    public void delete(T t);
    public T find(int id);
    public List<T> findAll();
}
