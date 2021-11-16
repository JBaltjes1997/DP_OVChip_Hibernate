package DAO;

import klassen.OVChipkaart;
import klassen.Product;
import org.hibernate.Session;

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
        return null;
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) {
        return null;
    }
}
