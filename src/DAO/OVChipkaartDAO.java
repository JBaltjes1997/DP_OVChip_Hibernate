package DAO;

import klassen.OVChipkaart;
import klassen.Product;
import klassen.Reiziger;

import java.util.List;

public interface OVChipkaartDAO {
    public void save(OVChipkaart ovchipkaart);
    public void update(OVChipkaart ovchipkaart);
    public void delete(OVChipkaart ovchipkaart);
    public List<OVChipkaart> findByReiziger(Reiziger reiziger);
//    public List<OVChipkaart> findByProduct(Product product);
    public List<OVChipkaart> findAll();
}
