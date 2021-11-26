package klassen;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column
    public int product_nummer;
    public String naam;
    public String beschrijving;
    public double prijs;

    public Product(int product_nummer, String naam, String beschrijving, double prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

//    @Transient
    @ManyToMany
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = {@JoinColumn(name = "product_nummer")},
            inverseJoinColumns={@JoinColumn(name = "kaart_nummer")} )
    private List<OVChipkaart> ovchipkaarten = new ArrayList<>();

    public Product() {
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public List<OVChipkaart> getOvchipkaarten() {
        return ovchipkaarten;
    }

    public void setOvchipkaarten(List<OVChipkaart> ovchipkaarten) {
        this.ovchipkaarten = ovchipkaarten;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_nummer=" + product_nummer +
//                ", naam='" + naam + '\'' +
//                ", beschrijving='" + beschrijving + '\'' +
//                ", prijs=" + prijs +
                ", ovchipkaarten=" + ovchipkaarten +
                '}';
    }
}
