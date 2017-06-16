package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.entity.Employee;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by magdalena.popek on 2017-06-08.
 */
public class HbnEmployeeDao implements IEmployeeDao{


    private Session session;

    public HbnEmployeeDao(Session session) {
        this.session = session;
    }

    public List <Employee> findByName(String name) {
        Query query = session.createQuery("from Employee e where e.name like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Employee> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                                                                                    +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Employee> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Employee> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Employee> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Employee> getAll() {
        return session.createQuery("from employee ", Employee.class).getResultList();
    }

    @Override
    public void addEntity(Employee entity) {
        session.saveOrUpdate(entity);
    }

    @Override
    public void deleteEntity(Employee entity) {

    }
}
