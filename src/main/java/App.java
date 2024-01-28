import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import rupesh.HibernateConfig;
import rupesh.entity.User;

/**
 * @author Rupesh Dangi
 * @date: 2024/01/27 16/43
 */
public class App {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            // FETCHING USER FROM CONTEXT
            User user = session.find(User.class,1L);
            user.addBalance(10);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
