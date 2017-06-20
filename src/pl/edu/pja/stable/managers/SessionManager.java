package pl.edu.pja.stable.managers;

import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnClientDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnEmployeeDao;

/**
 * Created by Magdalena on 2017-06-18.
 */
public class SessionManager {

    private static IClientDao clientDao = (IClientDao) new HbnClientDao();
    private static IEmployeeDao employeeDao = (IEmployeeDao) new HbnEmployeeDao();


    public static IClientDao getClientDao() {
        return clientDao;
    }

    public static IEmployeeDao getEmployeeDao() {
        return employeeDao;
    }

}
