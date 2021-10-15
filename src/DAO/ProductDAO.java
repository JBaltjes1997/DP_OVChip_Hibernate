package DAO;

import klassen.OVChipkaart;
import klassen.Product;

import java.util.List;

public interface ProductDAO {
    public boolean save(Product product);
    public boolean update(Product product);
    public boolean delete(Product product);
    public List<Product> findAll();
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);
}
