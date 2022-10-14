package domein.dao.Reiziger;

import domein.Reiziger;
import domein.dao.Adres.AdresDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;

public class ReizigerDAOhibernate implements ReizigerDAO{

    private Session session;
    private AdresDAO adresDAO;

    public ReizigerDAOhibernate(Session session) {
        this.session = session;
    }
    public ReizigerDAOhibernate(Session session, AdresDAO adresDAO) {
        this.session = session;
        this.adresDAO = adresDAO;
    }

    public void setAdresDAO(AdresDAO adresDAO) {
        this.adresDAO = adresDAO;
    }

    @Override
    public boolean save(Reiziger reiziger) {
        try{
            Transaction transaction = session.getTransaction();
            session.save(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Reiziger reiziger) {
        try{
            Transaction transaction = session.getTransaction();
            session.update(reiziger);
            transaction.commit();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try{
            Transaction transaction = session.getTransaction();
            session.delete(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Reiziger findById(int id) {
        return session.get(Reiziger.class, id);
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        return null;
    }

    @Override
    public List<Reiziger> findAll() {
        return null;
    }
}
