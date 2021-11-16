package DAO;

import klassen.Adres;
import klassen.Reiziger;

import java.util.List;

public interface AdresDAO{
    public void save(Adres adres);
    public void update(Adres adres);
    public void delete(Adres adres);
    public Adres findByReiziger(Reiziger reiziger);
    public List<Adres> findAll();
}
