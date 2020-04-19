import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctionsApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String avg = "select avg(e.sal) from Employee e";
        Query query = session.createQuery(avg);
        Double singleResult = (Double) query.getSingleResult();

        String sum = "select sum(e.sal) from Employee e";
        Query query1 = session.createQuery(sum);
        Long singleResult1 = (Long) query1.getSingleResult();

        String min = "select min(e.sal) from Employee e";
        Query query2 = session.createQuery(min);
        Integer singleResult2 = (Integer) query2.getSingleResult();

        String max = "select max(e.sal) from Employee e";
        Query query3 = session.createQuery(max);
        Integer singleResult3 = (Integer) query3.getSingleResult();

        session.getTransaction().commit();

        System.out.println("The result of the query is: " + singleResult);

        session.close();

    }

}
