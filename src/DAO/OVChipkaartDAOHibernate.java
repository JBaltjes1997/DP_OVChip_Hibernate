package DAO;

import klassen.OVChipkaart;
import klassen.Reiziger;
import org.hibernate.Session;

import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO{
    @Override
    public void save(OVChipkaart ovchipkaart) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.save(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(OVChipkaart ovchipkaart) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.update(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(OVChipkaart ovchipkaart) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.delete(ovchipkaart);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        return null;
    }

    @Override
    public List<OVChipkaart> findAll() {
        return null;
    }
}
