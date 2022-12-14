
import domein.Adres;
import domein.Product;
import domein.Reiziger;
import domein.dao.Adres.AdresDAO;
import domein.dao.Adres.AdresDAOhibernate;
import domein.dao.Reiziger.ReizigerDAOhibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        testFetchAll();
        testDAOhibernate();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAOhibernate() {
        Session session = getSession();
        session.beginTransaction();
        ReizigerDAOhibernate reizigerDAOhibernate = new ReizigerDAOhibernate(session);
        AdresDAOhibernate adresDAOhibernate = new AdresDAOhibernate(session, reizigerDAOhibernate);
        reizigerDAOhibernate.setAdresDAO(adresDAOhibernate);

        Reiziger reiziger = new Reiziger(7, "test", "test", "test", Date.valueOf("2002-02-02"));
        Adres adres = new Adres(reiziger, 7, "test", "test", "test", "test");
        reizigerDAOhibernate.save(reiziger);

    }
}
