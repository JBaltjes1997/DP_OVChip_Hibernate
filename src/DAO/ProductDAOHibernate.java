package DAO;

import klassen.Adres;
import klassen.OVChipkaart;
import klassen.Product;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO{

    private final Session currentSession;

    private Transaction transaction;

    public ProductDAOHibernate(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void startTransaction() {
        this.transaction = this.currentSession.beginTransaction();
    }

    public void closeTransaction(){
        this.transaction.commit();
    }

    @Override
    public void save(Product product) {
        try{
            this.currentSession.save(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        try{
            this.currentSession.update(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Product product) {
        try{
            this.currentSession.update(product);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
//        Transaction transaction = null;
//        List<Product> producten = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            producten = session.createQuery("FROM Product").list();
//
//            transaction.commit();
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//        }
//        return producten;
        return currentSession.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) {
//        Transaction transaction = null;
//        ArrayList<Product> producten = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            producten = (ArrayList<Product>)
//                    session.createQuery("select p.product_nummer, p.naam, p.beschrijving, p.prijs " +
//                    "from Product p" +
//                    " inner join OVChipkaart" +
//                    " where OVChipkaart.kaart_nummer = ?")
//                    .setParameter(0, ovChipkaart.getKaart_nummer()).list();
//
//            transaction.commit();
//
//            return producten;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
            return null;
//        }
//        List<Product> producten = this.currentSession
//                .createQuery("select p from Product p where kaart_nummer = :ovChipkaart")
//                .setParameter("ovChipkaart", ovChipkaart.getKaart_nummer()).getResultList();
//        currentSession.getTransaction().commit();
//        return producten;
    }
}
