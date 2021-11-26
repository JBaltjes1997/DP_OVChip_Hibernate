package DAO;

import klassen.OVChipkaart;
import klassen.Product;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{
    @Override
    public void save(Product product) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.save(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.update(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Product product) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.delete(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        Transaction transaction = null;
        List<Product> producten = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            producten = session.createQuery("FROM Product").list();

            transaction.commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return producten;
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) {
        Transaction transaction = null;
        ArrayList<Product> producten = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            producten = (ArrayList<Product>)
                    session.createQuery("select p.product_nummer, p.naam, p.beschrijving, p.prijs " +
                    "from Product p" +
                    " inner join OVChipkaart" +
                    " where OVChipkaart.kaart_nummer = ?")
                    .setParameter(0, ovChipkaart.getKaart_nummer()).list();

            transaction.commit();

            return producten;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
