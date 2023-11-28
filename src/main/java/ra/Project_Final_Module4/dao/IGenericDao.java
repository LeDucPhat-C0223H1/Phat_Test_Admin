package ra.Project_Final_Module4.dao;

import java.util.List;

public interface IGenericDao <T,E>{
    List<T> findAll();
    T findById(E id);
    int save(T t);
    int delete(E id);
}
