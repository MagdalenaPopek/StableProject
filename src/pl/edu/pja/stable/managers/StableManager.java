package pl.edu.pja.stable.managers;

import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.dao.ISessionDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnClientDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnEmployeeDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnSessionDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Employee;

import javax.persistence.metamodel.EntityType;
import javax.transaction.*;
import java.util.Date;

/**
 * Created by magdalena.popek on 2017-06-07.
 */

public class StableManager {

    IEmployeeDao employeeDao;
    IClientDao clientDao;
    ISessionDao sessionDao;

    public StableManager()
    {
        employeeDao = (IEmployeeDao) new HbnEmployeeDao();
        clientDao = (IClientDao) new HbnClientDao();
        sessionDao = (ISessionDao) new HbnSessionDao();
    };


    public void insertData() {
        Transaction t = null;
        try {
            t = sessionDao.beginTransaction();

      /* Add few employee records in database */
            Employee employee = new Employee();
            employee.setName("Magdalena");
            employee.setSurname("Popek");
            employee.setHireDate(new Date());
            employee.setSalary(2500);

            employeeDao.addEntity(employee);

            t.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        try {
            t = sessionDao.beginTransaction();

      /* Add few employee records in database */
            Client client = new Client();
            client.setName("Magdalena");
            client.setSurname("Popek");
            client.setPhoneNumber("+81 123-45-67");

            clientDao.addEntity(client);

            t.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

    }

    public void test() {
//        try {
//            System.out.println("Querying all the managed entities...");
//            final Metamodel metamodel = (HbnSessionDao) sessionDao.getSessionFactory.getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = sessionDao.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            //session.close();
//        }
    }


    public void run() {
        insertData();
    }

    public void close() {
        sessionDao.close();
    }


}
