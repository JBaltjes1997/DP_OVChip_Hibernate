package DAO;

import klassen.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface ReizigerDAO { // alle save,update, delete's naar void setten
    void save(Reiziger reiziger) throws SQLException;
    void update(Reiziger reiziger)throws SQLException;
    void delete(Reiziger reiziger) throws SQLException;
    Reiziger findById(int id)throws SQLException;
    List<Reiziger> findByGbDatum(String datum)throws SQLException;
    List<Reiziger> findAll()throws SQLException;
}
