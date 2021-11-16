package DAO;

import klassen.Adres;
import klassen.Reiziger;
import org.hibernate.Session;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO{
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
        return null;
    }

    @Override
    public List<Adres> findAll() {
        return null;
    }
}
