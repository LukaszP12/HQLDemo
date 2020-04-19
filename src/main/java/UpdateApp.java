import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        int id = 123;
        int salary = 15000;

        String update = "update Employee e set e.salary:=Salary where e.Employee_id:=id";
        Query query = session.createQuery(update);
        query.setParameter("id",id);
        query.setParameter("Salary",salary);
        query.executeUpdate();

        session.getTransaction().commit();

        session.close();

    }

}
