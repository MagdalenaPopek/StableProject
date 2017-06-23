package pl.edu.pja.stable.dao;

import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-08.
 */
public interface IEntityDao <T> {

    /*List<T> findByString(String searchColumnName, String searchText);

    List<T> findByDate(String searchColumnName, Date searchText);

    List<T> findByInteger(String searchColumnName, Integer searchText);

    List<T> findByBoolean(String searchColumnName, Boolean searchText);*/

    List<T> getAll();

    void addEntity(T entity);

    void deleteEntity(T entity);

    void updateEntity(T entity);
}
