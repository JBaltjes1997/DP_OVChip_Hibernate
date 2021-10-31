package klassen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Reiziger")
public class Reiziger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reiziger_id")
    private int reiziger_id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Adres", referencedColumnName = "adres_id")
    private Adres reizigerAdres;

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.reiziger_id = reiziger_id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public Reiziger() {
    }

//    public void setAdres(Adres a) {
//        reizigerAdres = a;
//    }
//
//    public Adres getAdres() {
//        return reizigerAdres;
//    }



    @Override
    public String toString() {
        return "Reiziger{" +
                "reiziger_id=" + reiziger_id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                '}';
    }
}
