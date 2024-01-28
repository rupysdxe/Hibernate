package rupesh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rupesh.entity.User;

public class HibernateConfig {

    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            // Database connection settings for H2
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "");
            configuration.setProperty("hibernate.connection.username", "");
            configuration.setProperty("hibernate.connection.password", "");
            configuration.setProperty("hibernate.transaction.coordinator_class", "jdbc");
            // Echo all executed DDL to stdout
            configuration.setProperty("hibernate.show_sql", "true");
            // Drop and re-create the database schema on startup
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            // Add annotated entity class
            configuration.addAnnotatedClass(User.class);
            // Build SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
