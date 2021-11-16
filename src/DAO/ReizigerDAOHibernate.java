package DAO;

import klassen.Reiziger;
import org.hibernate.Session;

import java.sql.SQLException;
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
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//
//            session.findById(id);
//
//
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        return null;
    }

    @Override
    public List<Reiziger> findByGbDatum(String datum) throws SQLException {
        return null;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        return null;
    }
}
