package DAO;

import klassen.Adres;
import klassen.OVChipkaart;
import klassen.Product;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO{

    private final Session currentSession;

    private Transaction transaction;

    public OVChipkaartDAOHibernate(Session currentSession) {
        this.currentSession = currentSession;
    }

    public void startTransaction() {
        this.transaction = this.currentSession.beginTransaction();
    }

    public void closeTransaction(){
        this.transaction.commit();
    }

    @Override
    public void save(OVChipkaart ovchipkaart) {
        try{
            this.currentSession.save(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(OVChipkaart ovchipkaart) {
        try{
            this.currentSession.update(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(OVChipkaart ovchipkaart) {
        try{
            this.currentSession.delete(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
//        Transaction transaction = null;
//        ArrayList<OVChipkaart> kaarten = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            kaarten = (ArrayList<OVChipkaart>) session.createQuery("from OVChipkaart where reiziger_id = ?")
//                    .setParameter(0, reiziger.getReiziger_id()).list();
//
//            transaction.commit();
//
//            return kaarten;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }

        List<OVChipkaart> kaarten = this.currentSession
                .createQuery("select o from OVChipkaart o where reiziger_id = :reiziger")
                .setParameter("reiziger", reiziger.getReiziger_id())
                .getResultList();
        currentSession.getTransaction().commit();
        return kaarten;
    }

//    @Override
//    public List<OVChipkaart> findByProduct(Product product){
//        Transaction transaction = null;
//        ArrayList<OVChipkaart> kaarten = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            kaarten = (ArrayList<OVChipkaart>) session.createQuery("select o.kaart_nummer, o.geldig_tot, o.klasse, o.saldo, o.reiziger_id" + "\n" +
//                    "from OVChipkaart o " +
//                    "inner join OVChipkaart_PRODUCT ovp" + "\n" +
//                    "on ovp.kaart_nummer = o.kaart_nummer" + "\n" +
//                    "and ovp.proudct_nummer = ?")
//
//                    .setParameter(0, product.getProduct_nummer()).list();
//
//            transaction.commit();
//
//            return kaarten;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }

    @Override
    public List<OVChipkaart> findAll() {
//        Transaction transaction = null;
//        List<OVChipkaart> kaarten = new ArrayList<>();
//        try{
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            transaction = session.beginTransaction();
//
//            kaarten = session.createQuery("FROM OVChipkaart ").list();
//
//            transaction.commit();
//
//            return kaarten;
//        }
//        catch(HibernateException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
        return currentSession.createQuery("SELECT o FROM OVChipkaart o", OVChipkaart.class).getResultList();
    }
}
