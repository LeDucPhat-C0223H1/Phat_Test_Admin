package ra.Project_Final_Module4.dao;

import java.util.List;

public interface IGenericDao <T,U,E>{
    List<T> findAll();
    List<U> findAllAndSearch (String query);
    List<U> findAllAndSearchAndPagination (String query, int limit, int offset);
    T findById(E id);
    int save(T t);
    int delete(E id);
}
