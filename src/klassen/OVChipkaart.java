package klassen;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ov_chipkaart")
public class OVChipkaart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int kaart_nummer;
    public Date geldig_tot;
    public int klasse;
    public double saldo;
    public int reiziger_id;

    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo, int reiziger_id) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger_id = reiziger_id;
    }

    public OVChipkaart() {
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger_id=" + reiziger_id +
                '}';
    }
}
