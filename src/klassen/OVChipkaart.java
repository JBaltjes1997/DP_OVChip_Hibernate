package klassen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ov_chipkaart")
public class OVChipkaart {
    @Id
    public int kaart_nummer;

    @Column
    public Date geldig_tot;
    public int klasse;
    public double saldo;
    public int reiziger_id;

    @ManyToOne
    @JoinColumn(name = "reiziger_id", insertable = false, updatable = false)
    private Reiziger reiziger;

//    @Transient
    @ManyToMany //(mappedBy = "ov_chipkaart")
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = {@JoinColumn(name = "kaart_nummer")},
            inverseJoinColumns={@JoinColumn(name = "product_nummer")} )
    private List<Product> producten = new ArrayList<>();

    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo, int reiziger_id) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger_id = reiziger_id;
    }

    public OVChipkaart() {
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
//                ", geldig_tot=" + geldig_tot +
//                ", klasse=" + klasse +
//                ", saldo=" + saldo +
                ", reiziger_id=" + reiziger_id +
//                ", reiziger=" + reiziger +
//                ", producten=" + producten +
                '}';
    }
}
