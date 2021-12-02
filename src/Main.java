import DAO.AdresDAOHibernate;
import DAO.OVChipkaartDAOHibernate;
import DAO.ProductDAOHibernate;
import DAO.ReizigerDAOHibernate;
import klassen.Adres;
import klassen.OVChipkaart;
import klassen.Product;
import klassen.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 *
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        testFetchAll();
//        testDAO_Hibernate();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAO_Hibernate() throws SQLException {

        Session session = getSession();

        ReizigerDAOHibernate reizigerDAO = new ReizigerDAOHibernate(session);
        reizigerDAO.startTransaction();

        String gbdatum = "1981-03-14";
        Reiziger John = new Reiziger(77, "J", null, "Boers", Date.valueOf(gbdatum));
//        reizigerDAO.save(Johnny);
//        reizigerDAO.update(John);

//        System.out.println(reizigerDAO.findById(77));

        reizigerDAO.delete(John);
//
        List<Reiziger> reizigers = reizigerDAO.findAll();
        for(Reiziger reiziger : reizigers){
            System.out.println(reiziger);
        }

//        List<Reiziger> GB_reizigers = reizigerDAO.findByGbDatum(gbdatum);
//        for(Reiziger GB_reiziger : GB_reizigers){
//            System.out.println(GB_reiziger);
//        }


//        reizigerDAO.closeTransaction();

//        AdresDAOHibernate aDAO = new AdresDAOHibernate(session);
//        aDAO.startTransaction();
//
//        String gebdatum = "1963-03-15";
//        Reiziger Peter = new Reiziger(88, "P", null, "Parker", java.sql.Date.valueOf(gebdatum));
//        reizigerDAO.save(John);
//        Adres adr = new Adres(12, "ABCD12", "7", "Somewhere over the Rainbowlaan", "Kansas-City", 77);
//        John.setAdres(adr);
//        adr.setReiziger(John);
//        aDAO.save(adr);
//        aDAO.update(adr);
//        aDAO.delete(adr);

//        List<Adres> adressen = aDAO.findAll();
//        for(Adres adres : adressen){
//            System.out.println(adres);
//        }

//        System.out.println(aDAO.findByReiziger(John));

//        aDAO.closeTransaction();


//        OVChipkaartDAOHibernate ovchipdao = new OVChipkaartDAOHibernate(session);
//        ovchipdao.startTransaction();
//
//        String vervalDatum = "2999-12-31";
//        OVChipkaart ovc = new OVChipkaart(00002, java.sql.Date.valueOf(vervalDatum), 2, 10000, 77);

//        John.addOvchipkaart(ovc);
//        ovc.setReiziger(John);
//        ovchipdao.save(ovc);
//        ovchipdao.update(ovc);
//
//        System.out.println(ovchipdao.findByReiziger(John));

//        List<OVChipkaart> ov_kaarten = ovchipdao.findAll();
//        for(OVChipkaart kaart : ov_kaarten){
//            System.out.println(kaart);
//        }
//
//        ovchipdao.delete(ovc);
//        ovchipdao.closeTransaction();


//        ProductDAOHibernate pDAO = new ProductDAOHibernate(session);
//        pDAO.startTransaction();

//        List<Product> producten = pDAO.findAll();;
//        for(Product p : producten){
//            System.out.println(p);
//        }

//        Product patent = new Product(7, "FBI", "idk", 0.01);
//        pDAO.findByOVChipkaart(ovc);
//        pDAO.save(patent);
//        pDAO.update(patent);
//        pDAO.delete(patent);
//        pDAO.closeTransaction();


    }

    }