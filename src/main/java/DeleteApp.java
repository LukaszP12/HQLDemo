import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);

        SessionFactory factory = conf.buildSessionFactory();

        Session session = factory.getCurrentSession();

        session.beginTransaction();

        int id = 123; // Id to be deleted

        String delete = "delete from Employee where Employee_id:=id";

        session.createQuery(delete).setParameter("Employee_id", id).executeUpdate();

        session.getTransaction().commit();

        session.close();

    }

}
