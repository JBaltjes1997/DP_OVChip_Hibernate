package DAO;

import klassen.Adres;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdresDAOHibernate implements AdresDAO{

    private final Sesseion

    @Override
    public void save(Adres adres) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.save(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Adres adres) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.update(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Adres adres) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.delete(adres);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Adres adres = (Adres) session.createQuery("from Adres where reiziger_id = ?")
                    .setParameter(0, reiziger.getReiziger_id());

            transaction.commit();

            return adres;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Adres> findAll() {
        Transaction transaction = null;
        List<Adres> adressen = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            adressen = session.createQuery("FROM Adres").list();

            transaction.commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return adressen;
    }
}
