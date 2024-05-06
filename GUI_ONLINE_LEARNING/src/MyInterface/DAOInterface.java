package MyInterface;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public int insert(T obj);
    public int update(T obj);
    public int delete(T obj);
    public ArrayList<T> selectAll();
    public T selectById(T obj);
    public ArrayList<T> selectByCondition(String condition);
}
