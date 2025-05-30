package RWServer.Services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("Verbunden!");

        } catch (RuntimeException ex) {
            System.out.println("Fehler!");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static void closeSession(Session session) {
        session.close();
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}