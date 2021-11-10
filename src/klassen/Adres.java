package klassen;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adres")
public class Adres {
    @Id
    @Column
    private int adres_id;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    private int reiziger_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reiziger_id", insertable = false, updatable = false)
    private Reiziger reiziger;


    public Adres() {
    }

    public Adres(int adres_id, String postcode, String huisnummer, String straat, String woonplaats, int reiziger_id) {
        this.adres_id = adres_id;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.reiziger_id = reiziger_id;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "adres_id=" + adres_id +
//                ", postcode='" + postcode + '\'' +
//                ", huisnummer='" + huisnummer + '\'' +
//                ", straat='" + straat + '\'' +
//                ", woonplaats='" + woonplaats + '\'' +
                ", reiziger_id=" + reiziger_id +
//                ", reiziger=" + reiziger +
                '}';
    }
}
