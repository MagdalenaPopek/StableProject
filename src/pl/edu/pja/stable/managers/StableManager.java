package pl.edu.pja.stable.managers;

import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnEmployeeDao;
import pl.edu.pja.stable.entity.Employee;

import javax.persistence.metamodel.EntityType;
import java.util.Date;

/**
 * Created by magdalena.popek on 2017-06-07.
 */

public class StableManager {

    IEmployeeDao employeeDao;
    Session session = HibernateSessionManager.getSession();

    public StableManager() {
        employeeDao = (IEmployeeDao) new HbnEmployeeDao(session);
    };


    public void insertData() {
        Transaction t = session.beginTransaction();

      /* Add few employee records in database */
        Employee employee = new Employee();
        employee.setName("Magdalena");
        employee.setSurname("Popek");
        employee.setHireDate(new Date());
        employee.setSalary(2500);

        employeeDao.addEntity(employee);

        t.commit();
    }

    public void test() {
        try {
            System.out.println("Querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            //session.close();
        }
    }


    public void run() {
        insertData();
    }

    public void close() {
        session.close();
    }


}
