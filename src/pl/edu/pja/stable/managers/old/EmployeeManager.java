package pl.edu.pja.stable.managers.old;

import pl.edu.pja.stable.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Magdalena Popek on 2017-06-07.
 */
public class EmployeeManager {

    public static SessionFactory factory;

    public static void createSession() {
        factory = new Configuration().
                configure("hibernate.cfg.xml").
                addPackage("pl/edu/pja/stable"). //add package if used.
                addAnnotatedClass(Employee.class).
                buildSessionFactory();
    }

    /* Method to CREATE an employee in the database */
    public Integer addEmployee(Date hDate, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee();
            employee.setHireDate(hDate);
            employee.setSalary(salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }


    /* Method to  READ all the employees */
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("Hire Date: " + employee.getHireDate());
                System.out.println("  Salary: " + employee.getSalary());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
