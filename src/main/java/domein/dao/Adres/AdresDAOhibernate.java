package domein.dao.Adres;

import domein.Adres;
import domein.Reiziger;
import domein.dao.Reiziger.ReizigerDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdresDAOhibernate implements AdresDAO{
    private Session session;
    private ReizigerDAO reizigerDAO;

    public AdresDAOhibernate(Session session, ReizigerDAO reizigerDAO) {
        this.session = session;
        this.reizigerDAO = reizigerDAO;
    }

    public AdresDAOhibernate(Session session) {
        this.session = session;
    }

    public void setReizigerDAO(ReizigerDAO reizigerDAO) {
        this.reizigerDAO = reizigerDAO;
    }

    @Override
    public boolean save(Adres adres) {
        try{
            Transaction transaction = session.getTransaction();
            session.save(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean update(Adres adres) {
        return false;
    }

    @Override
    public boolean delete(Adres adres) {
        return false;
    }

    @Override
    public Adres findById(int adres_id) {
        return null;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        return null;
    }

    @Override
    public List<Adres> findAll() {
        return null;
    }
}
