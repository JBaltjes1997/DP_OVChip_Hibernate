package DAO;

import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO{
    @Override
    public void save(Reiziger reiziger) throws SQLException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.save(reiziger);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Reiziger reiziger) throws SQLException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.update(reiziger);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Reiziger reiziger) throws SQLException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.delete(reiziger);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Reiziger reiziger = (Reiziger) session.createQuery("from Reiziger where reiziger_id = ?")
                    .setParameter(0, id);
            
            transaction.commit();

            return reiziger;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) throws SQLException {
        Transaction transaction = null;
        List<Reiziger> reizigers = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            reizigers = (List<Reiziger>) session.createQuery("from Reiziger where geboortedatum = ?")
                    .setParameter(0, datum).list();

            transaction.commit();

            return reizigers;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        Transaction transaction = null;
        List<Reiziger> reizigers = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            reizigers = session.createQuery("FROM Reiziger").list();

            transaction.commit();

            return reizigers;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
