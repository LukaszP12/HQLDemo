import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class NamedParamentersApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String employeeFirstName = "Steven";
        String employeeLastName = "King";

        String namedParameterString = "select e.firstName, e.lastName,e.salary from Employee e where e.firstName=:firstName and e.lastName:=lastName";

        Query namedParameterQuery = session.createQuery(namedParameterString);
        namedParameterQuery.setParameter("firstName",employeeFirstName);
        namedParameterQuery.setParameter("lastName",employeeLastName);

        List<Object[]> resultList = namedParameterQuery.getResultList();

        session.getTransaction().commit();

        session.close();

    }

}
