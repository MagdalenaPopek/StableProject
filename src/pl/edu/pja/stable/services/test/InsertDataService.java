package pl.edu.pja.stable.services.test;

import pl.edu.pja.stable.dao.*;
import pl.edu.pja.stable.daoimpl.hibernate.*;
import pl.edu.pja.stable.entity.*;

import java.util.Date;

/**
 * Created by Magdalena on 2017-06-07.
 */

public class InsertDataService {

    IEmployeeDao employeeDao;
    IClientDao clientDao;
    IOwnerDao ownerDao;
    IStableDao stableDao;
    IStallDao stallDao;

    public InsertDataService() {
        employeeDao = (IEmployeeDao) new HbnEmployeeDao();
        clientDao = (IClientDao) new HbnClientDao();
        ownerDao = (IOwnerDao) new HbnOwnerDao();
        stableDao = (IStableDao) new HbnStableDao();
        stallDao = (IStallDao) new HbnStallDao();
    }

    public void insertData() {
      /* Add few employee records in database */
       /* Employee employee;
        Client client;
        Owner owner;
        Stall stall;
        Stable stable;

        for (int a = 1; a < 5; a++) {

            //EMPLOYEE
            employee = new Employee();
            employee.setName("Marian");
            employee.setSurname("Pracownik(" + a + ")");
            employee.setHireDate(new Date());
            employee.setSalary(500 * a);
            System.out.println("Create employee " + a);
            employeeDao.addEntity(employee);

            //CLIENT
            client = new Client();
            client.setName("Stefan");
            client.setSurname("Klient(" + a + ")");
            client.setPhoneNumber("+81 " + a + "23-45-" + a + "7");
            System.out.println("Create client " + a);
            clientDao.addEntity(client);

            //OWNER
            owner = new Owner();
            owner.setName("Zbyszek");
            owner.setSurname("Owner(" + a + ")");
            owner.setPhoneNumber("+81 " + a + "23-45-" + a + "7");
            System.out.println("Create owner " + a);
            ownerDao.addEntity(owner);

            //STABLE
            stable = new Stable();
            stable.setStableName("Stajnia nr "+a);
            stable.setStableAddress("Stajenna "+a);
            stable.setDirector(employee);
            System.out.println("Create stable " + a);
            stableDao.addEntity(stable);

            //STALL IN STABLE
            for(int b=1; b<11; b++){
                stall = new Stall();
                stall.setStable(stable);
                stall.setStallNumber(b);
                stall.setArea(50);
                System.out.println("Create stall " + b);
                stallDao.addEntity(stall);
            }
        }*/
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
