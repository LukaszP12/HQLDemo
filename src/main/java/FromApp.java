import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

public class FromApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String from = "FROM Employee";
        // String from2 = "from Employee"; it is case insensitive
        // in case of entity name collision the entity name has to
        // be given including the package name

        Query query = session.createQuery(from);
        List<Employee> resultList = query.getResultList();

        session.getTransaction().commit();

        for (Employee employee : resultList){
            System.out.println(employee);
        }

        factory.close();

    }

}
