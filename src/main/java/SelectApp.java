import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SelectApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String select = "select firstName, lastName from Employee";
        String select2 = "select e.firstName, e.lastName from Employee as e";
        String select3 = "select e.firstName, e.lastName from Employee e";
        String select4 = "select e.firstName,e.lastName from Employee e order by e.firstName"; // order by

        Query query = session.createQuery(select);
        List<Object> resultList = query.getResultList();

        for (Object result : resultList){
            System.out.println(result);
        }

        Query query1 = session.createQuery(select2);
        List<Object> resultList1 = query1.getResultList();

        Query query2 = session.createQuery(select4);
        List<Object> resultListOrderBy = query2.getResultList();


        session.getTransaction().commit();

        factory.close();

    }

}
