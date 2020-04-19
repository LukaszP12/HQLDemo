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
        Query query = session.createQuery(select);
        List<Object> resultList = query.getResultList();

        for (Object result : resultList){
            System.out.println(result);
        }

        session.getTransaction().commit();

        factory.close();

    }

}
