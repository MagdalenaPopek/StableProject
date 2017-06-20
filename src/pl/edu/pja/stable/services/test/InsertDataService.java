package pl.edu.pja.stable.services.test;

import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnClientDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnEmployeeDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Employee;

import java.util.Date;

/**
 * Created by Magdalena on 2017-06-07.
 */

public class InsertDataService {

    IEmployeeDao employeeDao;
    IClientDao clientDao;

    public InsertDataService() {
        employeeDao = (IEmployeeDao) new HbnEmployeeDao();
        clientDao = (IClientDao) new HbnClientDao();
    }

    ;


    public void insertData() {
      /* Add few employee records in database */
        Employee employee;
        Client client;

        for(int a=1; a<5; a++)
        {
            employee = new Employee();
            employee.setName("Marian");
            employee.setSurname("Pracownik("+a+")");
            employee.setHireDate(new Date());
            employee.setSalary(500*a);

            System.out.println("Create employee "+a);
            employeeDao.addEntity(employee);

      /* Add few employee records in database */
            client = new Client();
            client.setName("Stefan");
            client.setSurname("Klient("+a+")");
            client.setPhoneNumber("+81 "+a+"23-45-"+a+"7");

            System.out.println("Create client "+a);
            clientDao.addEntity(client);
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


}
