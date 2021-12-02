package DAO;

import klassen.Adres;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AdresDAOHibernate implements AdresDAO{

    private final Session currentSession;

    private Transaction transaction;

    public AdresDAOHibernate(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void startTransaction() {
        this.transaction = this.currentSession.beginTransaction();
    }

    public void closeTransaction(){
        this.transaction.commit();
    }


    @Override
    public void save(Adres adres) {
        try{

            this.currentSession.save(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Adres adres) {
        try{
            this.currentSession.update(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Adres adres) {
        try{
            this.currentSession.delete(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
//        Transaction transaction = null;
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            Adres adres = (Adres) session.createQuery("from Adres where reiziger_id = ?")
//                    .setParameter(0, reiziger.getReiziger_id());
//
//            transaction.commit();
//
//            return adres;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }

//        Adres adres = currentSession.load(Adres.class, reiziger.getReiziger_id());
//        currentSession.getTransaction().commit();
//        return adres;

        Adres adres = (Adres) this.currentSession
                .createQuery("select a from Adres a where reiziger_id = :reiziger")
                .setParameter("reiziger", reiziger.getReiziger_id()).getSingleResult();
        currentSession.getTransaction().commit();
        return adres;

    }

    @Override
    public List<Adres> findAll() {
//        Transaction transaction = null;
//        List<Adres> adressen = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            adressen = session.createQuery("FROM Adres").list();
//
//            transaction.commit();
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//        }
//        return adressen;
        return currentSession.createQuery("SELECT a FROM Adres a", Adres.class).getResultList();
    }
}
