package DAO;

import klassen.OVChipkaart;
import klassen.Product;

import java.util.List;

public interface ProductDAO {
    public void save(Product product);
    public void update(Product product);
    public void delete(Product product);
    public List<Product> findAll();
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);
}
