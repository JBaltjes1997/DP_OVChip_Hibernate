package DAO;

import klassen.Reiziger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {

    private final Session currentSession;

    private Transaction transaction;

    public ReizigerDAOHibernate(Session currentSession) {
        this.currentSession = currentSession;
    }

//    public AdresDAOHibernate(Session currentAdresSession) {
//        this.currentSession = currentAdresSession;
//    }

    public void startTransaction() {
        this.transaction = this.currentSession.beginTransaction();
    }

    public void closeTransaction() {
        this.transaction.commit();
    }

    @Override
    public void save(Reiziger reiziger) throws SQLException {
        try {
            this.currentSession.save(reiziger);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Reiziger reiziger) throws SQLException {
        try {
            this.currentSession.update(reiziger);

//            if(Adres.findByReiziger(reiziger) != null) {
//                this.currentSession.update(reiziger.getAdres());
//            } else {
//                this.currentSession.save(reiziger.getAdres());
//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Reiziger reiziger) throws SQLException {
        try {
            this.currentSession.delete(reiziger);

            if(reiziger.getAdres() != null){
                this.currentSession.delete(reiziger.getAdres());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
//        Transaction transaction = null;
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            Reiziger reiziger = (Reiziger) session.createQuery("from Reiziger where reiziger_id = ?")
//                    .setParameter(0, id);
//
//            transaction.commit();
//
//            return reiziger;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//        currentSession.beginTransaction();
        Reiziger reiziger = currentSession.load(Reiziger.class, id);
        currentSession.getTransaction().commit();
        return reiziger;

//        return currentSession.createQuery("select r FROM Reiziger r", Reiziger.class, id).List();
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) throws SQLException {
//        Transaction transaction = null;
//        List<Reiziger> reizigers = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            reizigers = (List<Reiziger>) session.createQuery("from Reiziger where geboortedatum = ?")
//                    .setParameter(0, datum).list();
//
//            transaction.commit();
//
//            return reizigers;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//        currentSession.beginTransaction();
        List<Reiziger> reizigers = this.currentSession
                .createQuery("select r from Reiziger r where geboortedatum = :datum")
                .setParameter("datum", Date.valueOf(datum))
                .getResultList();
        currentSession.getTransaction().commit();
        return reizigers;
//        Criteria criteria = currentSession.createCriteria(Reiziger.class);
//        List<Reiziger> reizigers = criteria.add(Restrictions.eq("geboortedatum", datum))
//                .list();
//        return reizigers;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
//        Transaction transaction = null;
//        List<Reiziger> reizigers = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            reizigers = session.createQuery("FROM Reiziger").list();
//
//            transaction.commit();
//
//            return reizigers;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
        return currentSession.createQuery("SELECT r FROM Reiziger r", Reiziger.class).getResultList();
    }
}
