import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class WhereApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String where = "from Employee where firstName='Tadeusz";
        String where2 = "from Employee where salary > 12000";
        String where3 = "from Employee where salary < 3000 or > 13000";
        String where4 = "from Employee where salary is null";
        String where5 = "from Employee where lastName in ('Hutton','Errazuriz','Wiśniewski')";

        Query query = session.createQuery(where);
        List<Employee> resultList = query.getResultList();

        Query query1 = session.createQuery(where2);
        List<Employee> resultList1 = query1.getResultList();

        Query query2 = session.createQuery(where3);
        List<Employee> resultList2 = query2.getResultList();

        Query query3 = session.createQuery(where4);
        List<Employee> resultList3 = query3.getResultList();

        Query query4 = session.createQuery(where5);
        List<Employee> resultList4 = query4.getResultList();

        session.getTransaction().commit();

        for (Employee employee : resultList){
            System.out.println("First name:" + employee.getFirstName() + "last name:" + employee.getLastName() + "earns" + employee.getSalary() );
        }

        factory.close();

    }

}
